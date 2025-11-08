package niteknightt.chess.lichessapi;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class NdjsonParser<T> implements ResponseParser<List<T>> {
    private final Class<T> cls;
    private final Gson gson = new Gson();

    public NdjsonParser(Class<T> cls) {
        this.cls = cls;
    }

    @Override
    public List<T> parse(String json) {
        List<T> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new StringReader(json))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    list.add(gson.fromJson(line, cls));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
