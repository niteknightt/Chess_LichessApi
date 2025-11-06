package niteknightt.chess.lichessapi.functions;

import niteknightt.chess.lichessapi.LichessInterface;
import niteknightt.chess.lichessapi.objects.ExportedGame;
import niteknightt.chess.lichessapi.objects.UserProfile;

public class Games {
    public static ExportedGame exportLastGameOfAUser(String username) {
        return LichessInterface.httpSyncGetWrapper("games/user/" + username + "?max=1&clocks=true&pgnInJson=true&rated=true", ExportedGame.class);
    }
}
