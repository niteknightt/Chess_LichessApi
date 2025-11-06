package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;
import niteknightt.chess.lichessapi.LichessUsersEnums;

import java.util.Map;

/**
 * Activity of a user for a specific variant.
 */
public class VariantActivity extends LichessApiObject {

    /**
     * Number of wins.
     */
    int win;

    /**
     * Number of losses.
     */
    int loss;

    /**
     * Number of draws.
     */
    int draw;

    /**
     * Change in rating.
     */
    RatingsChange rp;
}
