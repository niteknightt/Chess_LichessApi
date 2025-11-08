package niteknightt.chess.lichessapi;

public interface ResponseParser<R> {
    R parse(String json);
}
