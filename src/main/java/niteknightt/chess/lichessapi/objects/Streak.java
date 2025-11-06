package niteknightt.chess.lichessapi.objects;

/**
 * Info about a streak of games.
 */
public class Streak {
    /**
     * Number of games in the streak (I think) TODO: Verify.
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
