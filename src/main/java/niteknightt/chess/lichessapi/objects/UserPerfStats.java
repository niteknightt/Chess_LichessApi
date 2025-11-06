package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;
import niteknightt.chess.lichessapi.LichessUsersEnums;

import java.util.*;

/**
 * Performance statistics of a user.
 */
public class UserPerfStats extends LichessApiObject {

    /**
     * The user.
     */
    public User user;

    /**
     * The user's performance.
     */
    public Performance perf;

    /**
     * Where the user is compared to other users (maybe?).
     * TODO: Figure this out. Also why can it be null? What will happen?
     */
    public int rank;

    /**
     * The percentile of the user among all users.
     */
    public float percentile;

    /**
     * Information for this user and this variant.
     */
    public VariantStats stat;
}
