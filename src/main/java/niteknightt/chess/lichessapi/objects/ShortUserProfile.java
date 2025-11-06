package niteknightt.chess.lichessapi.objects;

import com.google.gson.annotations.SerializedName;
import niteknightt.chess.lichessapi.LichessAccountEnums;
import niteknightt.chess.lichessapi.LichessApiObject;
import niteknightt.chess.lichessapi.LichessUsersEnums;

import java.util.Map;

/**
 * Short account profile on Lichess.
 */
public class ShortUserProfile extends LichessApiObject {

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
    public Map<LichessUsersEnums.VariantKey, ShortProfilePerf> profilePerfs;

    /**
     * User's title or bot indicator.
     */
    public LichessAccountEnums.Title title;

    /**
     * Is the user a patron.
     */
    public boolean patron;

    /**
     * Is the user currently online.
     */
    public boolean online;
}
