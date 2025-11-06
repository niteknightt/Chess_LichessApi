package niteknightt.chess.lichessapi.objects;

import com.google.gson.annotations.SerializedName;
import niteknightt.chess.lichessapi.*;

import java.util.Map;

/**
 * Account profile on Lichess.
 */
public class UserProfile extends LichessApiObject {

    /**
     * Internal ID used by Lichess.
     */
    public String id;

    /**
     * Username that is displayed.
     */
    public String username;

    /**
     * Map of performance statistics for each chess variation.
     * Possible keys are LichessConstants.ChessVariants.
     */
    @SerializedName("perfs")
    public Map<LichessAccountEnums.PerfsKey, ProfilePerf> profilePerfs;

    /**
     * User's title or bot indicator.
     */
    public LichessAccountEnums.Title title;

    /**
     * Which flair is displayed (only relevant if patron == true).
     */
    public String flair;

    /**
     * Timestamp that the account was created.
     */
    public long createdAt;

    /**
     * Is the account closed. Only in response if true.
     */
    public boolean disabled;

    /**
     * Does the account have a TOS violation. Only in response if true.
     */
    public boolean tosViolation;

    /**
     * Information the user added to their profile.
     */
    @SerializedName("profile")
    public PublicProfile personalProfile;

    /**
     * Timestamp of last login.
     */
    public long seenAt;

    /**
     * Amount of time the account has played.
     */
    public PlayTime playTime;

    /**
     * Displayed color of patron wings. Values are 1 - 10.
     * Colors can be found here:
     * https://github.com/lichess-org/lila/blob/master/ui/lib/css/abstract/_patron-colors.scss
     */
    public int patronColor;

    /**
     * Is the user verified.
     */
    public boolean verified;

    /**
     * URL to user's public profile.
     */
    public String url;

    /**
     * URL to current game being played, if it exists.
     */
    public String playing;

    /**
     * Statistics about the number of games the account has played.
     */
    @SerializedName("count")
    public Map<LichessAccountEnums.CountType, Integer> counts;

    /**
     * Is the user currently streaming.
     */
    public boolean streaming;

    /**
     * Streamer info.
     * Only relevant for accounts that stream.
     */
    public StreamerInfo streamer;

    /**
     * Is account followable by current user.
     * TODO: Verify meaning of variable.
     */
    public boolean followable;

    /**
     * Is account following current user.
     * TODO: Verify meaning of variable.
     */
    public boolean following;

    /**
     * Is account blocking current user.
     * TODO: Verify meaning of variable.
     */
    public boolean blocking;
}
