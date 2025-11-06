package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;
import niteknightt.chess.lichessapi.LichessUsersEnums;

import java.util.Map;

/**
 * Information about a tournament.
 */
public class TournamentInfo extends LichessApiObject {

    /**
     * ID of the tournament.
     */
    String id;

    /**
     * Name of the tournament.
     */
    String name;
}
