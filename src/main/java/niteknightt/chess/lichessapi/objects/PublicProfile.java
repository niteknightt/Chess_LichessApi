package niteknightt.chess.lichessapi.objects;

/**
 * Personal information a user added to their account profile.
 */
public class PublicProfile {
    /**
     * Flag user displays.
     */
    public String flag;

    /**
     * User's location.
     */
    public String location;

    /**
     * User's bio.
     */
    public String bio;

    /**
     * User's real name.
     */
    public String realName;

    /**
     * User's FIDE rating. Only in response if user set it.
     */
    public int fideRating;

    /**
     * User's USCF rating. Only in response if user set it.
     */
    public int uscfRating;

    /**
     * User's ECF rating. Only in response if user set it.
     */
    public int ecfRating;

    /**
     * User's CFC rating. Only in response if user set it.
     */
    public int cfcRating;

    /**
     * User's RCF rating. Only in response if user set it.
     */
    public int rcfRating;

    /**
     * User's DSB rating. Only in response if user set it.
     */
    public int dsbRating;

    /**
     * User's links. Single string separated by spaces.
     */
    public String links;
}
