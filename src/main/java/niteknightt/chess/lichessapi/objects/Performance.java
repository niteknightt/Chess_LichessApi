package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;

/**
 * Performance statistics.
 */
public class Performance extends LichessApiObject {

    /**
     * The Glicko rating.
     */
    public GlickoDetails glicko;

    /**
     * Number of games (I think). TODO: Verify
     */
    public int nb;

    /**
     * Change over last 10 games (I think). TODO: Verify
     */
    public int progress;
}
