package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;
import niteknightt.chess.lichessapi.LichessUsersEnums;

import java.util.Map;

/**
 * How user performed in tournament.
 */
public class UserTournamentResult extends LichessApiObject {

    /**
     * Info about the tournament.
     */
    TournamentInfo tournament;

    /**
     * Number of games the user played.
     */
    int nbGames;

    /**
     * User's score.
     */
    int score;

    /**
     * User's rank.
     */
    int rank;

    /**
     * User's rank percent.
     */
    int rankPercent;
}
