package niteknightt.chess.lichessapi;

import com.google.gson.Gson;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;
import niteknightt.chess.lichessapi.objects.ExportedGame;
import org.checkerframework.checker.units.qual.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StandardJsonParser<R> implements ResponseParser<R> {

    private final Class<R> type;
    private final boolean specialHandling;
    private final String apiName;

    private static final Gson gson = new Gson();

    public StandardJsonParser(Class<R> type) {
        this(type, false, null);
    }

    public StandardJsonParser(Class<R>  type, boolean specialHandling, String apiName) {
        this.type = type;
        this.specialHandling = specialHandling;
        this.apiName = apiName;
    }

    private String extraParsing(String input) {
        // Add keys to points fields.
        StringBuffer sbOutput = new StringBuffer();
        int endOfLastVariantPos = -1;
        int pointsPos = input.indexOf("\"points\":", endOfLastVariantPos);
        while (pointsPos != -1) {
            int endOfThisVariantPos = input.indexOf('}', pointsPos);
            if (endOfThisVariantPos == -1) {
                // TODO: Log an error and decide how to handle it.
                return input;
            }
            int outerOpenBracketPos = input.indexOf('[', pointsPos);
            if (outerOpenBracketPos == -1 || outerOpenBracketPos > endOfThisVariantPos) {
                // TODO: Log an error and decide how to handle it.
                return input;
            }
            int outerCloseBracketPos = input.lastIndexOf(']', endOfThisVariantPos);
            if (outerCloseBracketPos == -1 || outerCloseBracketPos < outerOpenBracketPos) {
                // TODO: Log an error and decide how to handle it.
                return input;
            }
            List<Integer> opens = new ArrayList<>();
            List<Integer> closes = new ArrayList<>();
            int innerOpenBracketPos = input.indexOf('[', outerOpenBracketPos + 1);
            while (innerOpenBracketPos != -1 && innerOpenBracketPos < outerCloseBracketPos) {
                int innerCloseBracketPos = input.indexOf(']', innerOpenBracketPos + 1);
                if (innerCloseBracketPos == -1 || innerCloseBracketPos >= outerCloseBracketPos) {
                    // TODO: Log an error and decide how to handle it.
                    return input;
                }
                opens.add(innerOpenBracketPos);
                closes.add(innerCloseBracketPos);
                innerOpenBracketPos = input.indexOf('[', innerCloseBracketPos + 1);
            }

            sbOutput.append(input.substring(endOfLastVariantPos + 1, outerOpenBracketPos + 1));
            for (int i = 0; i < opens.size(); ++i) {
                int open = opens.get(i);
                int close = closes.get(i);
                String innerPoints = input.substring(open + 1, close);
                String[] innerNumbers = innerPoints.split("\\s*,\\s*"); // Regex provided by chatgpt to handle whitespaces.
                if (innerNumbers.length != 4) {
                    // TODO: Log an error and decide how to handle it.
                    continue;
                }
                StringBuffer sb = new StringBuffer();
                sb.append("\"year\":");
                sb.append(innerNumbers[0]);
                sb.append(',');
                sb.append("\"month\":");
                sb.append(innerNumbers[1]);
                sb.append(',');
                sb.append("\"day\":");
                sb.append(innerNumbers[2]);
                sb.append(',');
                sb.append("\"value\":");
                sb.append(innerNumbers[3]);
                if (i > 0) {
                    sbOutput.append(',');
                }
                sbOutput.append('{');
                sbOutput.append(sb);
                sbOutput.append('}');
            }
            sbOutput.append("]}");
            endOfLastVariantPos = endOfThisVariantPos;
            pointsPos = input.indexOf("\"points\":", endOfLastVariantPos + 1);
        }

        sbOutput.append(input.substring(endOfLastVariantPos + 1));
        return sbOutput.toString();
    }

    private int parseSingleGame(String json, StringBuffer sb, int startPos) {
        int pgnPos = json.indexOf("\"pgn\":", startPos);
        if (pgnPos == -1) {
            return -1;
        }
        int startQuote = json.indexOf('"', pgnPos + 6);
        if (startQuote == -1) {
            // TODO: Log an error and decide how to handle it.
        }
        int closeQuotePos = startQuote + 1;
        while (closeQuotePos < json.length()) {
            closeQuotePos = json.indexOf('"', closeQuotePos);
            if (closeQuotePos == -1) {
                // TODO: Log an error and decide how to handle it.
            }
            int backslashCount = 0;
            int i = closeQuotePos - 1;
            while (i >= 0 && json.charAt(i) == '\\') {
                backslashCount++;
                i--;
            }

            if (backslashCount % 2 == 0) {
                break;
            }
            closeQuotePos++;
        }
        if (closeQuotePos == -1) {
            // TODO: Log an error and decide how to handle it.
        }
        String val = json.substring(startQuote, closeQuotePos + 1);

        while (val.charAt(val.length() - 2) == 'n' && val.charAt(val.length() - 3) == '\\') {
            val = val.substring(0, val.length() - 3) + "\"";
        }

        sb.append(val);
        return closeQuotePos;
    }

    @Override
    public R parse(String json) throws Exception {
        // Protobuf parsing
        Message.Builder builder = (Message.Builder) type
                .getMethod("newBuilder").invoke(null);

        String toParse = json;

        if (specialHandling && "GetRealTimeUserStatus".equals(apiName)) {
            toParse = "{\"statuses\": " + json + "}";
        }

        if (specialHandling && "GetUserRatingHistory".equals(apiName)) {
            toParse = "{\"ratingHistory\": " + json + "}";
            System.out.println("Before points:");
            System.out.println(toParse);
            toParse = extraParsing(toParse);
            System.out.println("After points:");
            System.out.println(toParse);
        }

        if (specialHandling && "ExportLastGameOfAUser".equals(apiName)) {
            StringBuffer sb = new StringBuffer();
            int endPos = parseSingleGame(json, sb, 0);
            StringBuffer toParseSb = new StringBuffer();
            toParseSb.append("{\"games\": ");
            toParseSb.append(sb);
            toParseSb.append("}");
            toParse = toParseSb.toString();
        }

        if (specialHandling && "ExportLastGamesOfAUser".equals(apiName)) {
            StringBuffer toParseSb = new StringBuffer();
            toParseSb.append("{\"games\": [");
            int returnedPos = 0;
            while (returnedPos != -1) {
                int prevPos = returnedPos;
                StringBuffer sb = new StringBuffer();
                returnedPos = parseSingleGame(json, sb, returnedPos);
                if (returnedPos != -1) {
                    if (prevPos != 0) {
                        toParseSb.append(",");
                    }
                    toParseSb.append(sb);
                }
            }
            toParseSb.append("]}");
            toParse = toParseSb.toString();
        }

        JsonFormat.parser().ignoringUnknownFields().merge(toParse, builder);
        return (R) builder.build();
    }

// /// //// /// // OLD: WORKS FOR PROTO ONLY
/*
    private final Type type;
    private final Gson gson = new Gson();

    public StandardJsonParser(Type type) {
        this.type = type;
    }

    @Override
    public R parse(String json) {
        // Get the static newBuilder() method
        try {
            Class ac = type.getClass();
            Class ad = Class.forName(type.getTypeName());
            Method newBuilderMethod = ad.getMethod("newBuilder");
//            Method newBuilderMethod = type.getClass().getMethod("newBuilderForType");
            Message.Builder builder = (Message.Builder) newBuilderMethod.invoke(null);

            // Parse JSON into builder
            JsonFormat.parser()
                    .ignoringUnknownFields()
                    .merge(json, builder);

            // Build immutable message and return
            return (R) builder.build();
        }
        catch (Exception ex) {
            throw new RuntimeException("HHHEEELLLPPP");
        }
    }

//    @Override
//    public R parse(String json) {
//        return gson.fromJson(json, type);
//    }
*/
}
