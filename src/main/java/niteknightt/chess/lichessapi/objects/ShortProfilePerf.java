package niteknightt.chess.lichessapi.objects;

/**
 * Short info about account for a chess variant.
 */
public class ShortProfilePerf {

    /**
     * Rating for this variation.
     */
    public int rating;

    /**
     * Rating change in last 10 games. TODO: Check that it is really 10 games.
     */
    public int progress;

}
