package niteknightt.chess.lichessapi.objects;

/**
 * Info about a play time stretch.
 */
public class MaxPlayTime {
    /**
     * Number of second in the time (I think) TODO: Verify.
     */
    public int v;

    /**
     * First game in the time.
     */
    public DateAndGame from;

    /**
     * Last game in the time.
     */
    public DateAndGame to;
}
