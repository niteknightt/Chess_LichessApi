package niteknightt.chess.lichessapi;

import com.google.gson.Gson;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

import java.lang.reflect.Type;

public class GsonTypeParser<R> implements ResponseParser<R> {
    private static final Gson gson = new Gson();
    private final Type type;

    public GsonTypeParser(Type type) {
        this.type = type;
    }

    @Override
    public R parse(String json) {
        return gson.fromJson(json, type);
    }
}
