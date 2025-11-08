package niteknightt.chess.lichessapi;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class StandardJsonParser<R> implements ResponseParser<R> {
    private final Type type;
    private final Gson gson = new Gson();

    public StandardJsonParser(Type type) {
        this.type = type;
    }

    @Override
    public R parse(String json) {
        return gson.fromJson(json, type);
    }
}
