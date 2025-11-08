package niteknightt.chess.lichessapi.functions;

import niteknightt.chess.lichessapi.LichessInterface;
import niteknightt.chess.lichessapi.NdjsonParser;
import niteknightt.chess.lichessapi.StandardJsonParser;
import niteknightt.chess.lichessapi.objects.ExportedGame;
import niteknightt.chess.lichessapi.objects.UserProfile;

import java.util.List;

public class Games {
    public static ExportedGame exportLastGameOfAUser(String username) {
        return LichessInterface.httpSyncGetWrapper("games/user/" + username + "?max=1&clocks=true&pgnInJson=true&rated=true", new StandardJsonParser<>(ExportedGame.class));
    }
    public static List<ExportedGame> exportLastGamesOfAUser(String username, int numGames) {
        return LichessInterface.httpSyncGetWrapper("games/user/" + username + "?max=" + numGames + "&clocks=true&pgnInJson=true&rated=true", new NdjsonParser<>(ExportedGame.class));
    }
}
