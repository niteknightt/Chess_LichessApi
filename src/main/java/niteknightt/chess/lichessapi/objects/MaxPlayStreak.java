package niteknightt.chess.lichessapi.objects;

/**
 * Info about a play streak.
 */
public class MaxPlayStreak {
    /**
     * Number of second in the streak (I think) TODO: Verify.
     */
    public int v;

    /**
     * First game in the streak.
     */
    public DateAndGame from;

    /**
     * Last game in the streak.
     */
    public DateAndGame to;
}
