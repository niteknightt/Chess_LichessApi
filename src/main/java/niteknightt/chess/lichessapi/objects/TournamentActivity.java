package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;
import niteknightt.chess.lichessapi.LichessUsersEnums;

import java.util.List;
import java.util.Map;

/**
 * Tournament activity of a user.
 */
public class TournamentActivity extends LichessApiObject {

    /**
     * Number of tournaments.
     */
    int nb;

    /**
     * Best results.
     */
    List<UserTournamentResult> best;

}
