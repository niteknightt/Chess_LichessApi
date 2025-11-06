package niteknightt.chess.lichessapi.objects;

/**
 * Info about account for a chess variant.
 */
public class ProfilePerf {

    /**
     * Number of games played.
     * Relevant for all variants except storm, racer, and streak.
     */
    public int games;

    /**
     * Rating for this variation.
     * Relevant for all variations except storm, racer, and streak.
     */
    public int rating;

    /**
     * Reliability deviation for this variation.
     * Relevant for all variations except storm, racer, and streak.
     */
    public int rd;

    /**
     * Rating change in last 10 games. TODO: Check that it is really 10 games.
     * Relevant for all variations except storm, racer, and streak.
     */
    public int prog;

    /**
     * Is the account provisional for this variation.
     * Relevant for all variations except storm, racer, and streak.
     * Will not be in response if the value is false.
     */
    public boolean prov;

    /**
     * Number of times played.
     * Relevant only for storm, racer, and streak.
     */
    public int runs;

    /**
     * High score for this variation.
     * Relevant only for storm, racer, and streak.
     */
    public int score;
}
