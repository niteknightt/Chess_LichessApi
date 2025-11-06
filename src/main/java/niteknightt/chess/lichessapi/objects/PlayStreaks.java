package niteknightt.chess.lichessapi.objects;

/**
 * User's current and longest streaks of playing.
 */
public class PlayStreaks {
    /**
     * Play streaks.
     */
    public CurAndMaxPlayStreaks nb;

    /**
     * Time of streaks.
     */
    public CurAndMaxPlayTime time;

    /**
     * When last streak occurred, in usual datetime format.
     */
    String lastDate;
}
