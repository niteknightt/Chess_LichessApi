package niteknightt.chess.lichessapi.objects;

/**
 * Amount of time a user account has played.
 */
public class PlayTime {
    /**
     * Time in seconds the account has played.
     */
    public long total;

    /**
     * Time in seconds the account played on Lichess TV.
     */
    public long tv;

    /**
     * Time in seconds the account played against humans.
     * Only relevant for bot accounts.
     * TODO: See if possible to verify the meaning of this.
     * TODO: Double-check that this is actually there.
     */
    public long human;
}
