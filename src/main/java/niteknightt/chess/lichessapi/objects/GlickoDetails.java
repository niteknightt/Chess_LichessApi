package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;

/**
 * Details of a glicko rating.
 */
public class GlickoDetails extends LichessApiObject {

    /**
     * The rating.
     */
    public float rating;

    /**
     * The rating deviation.
     */
    public float deviation;

    /**
     * Is the rating provisional.
     */
    public boolean provisional;

}
