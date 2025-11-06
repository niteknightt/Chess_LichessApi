package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;
import niteknightt.chess.lichessapi.LichessUsersEnums;

import java.util.Map;

/**
 * Change of rating
 */
public class RatingsChange extends LichessApiObject {

    /**
     * Start rating.
     */
    int before;

    /**
     * End rating.
     */
    int after;
    
}
