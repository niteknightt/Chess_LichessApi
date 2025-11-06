package niteknightt.chess.lichessapi.objects;

import com.google.gson.annotations.SerializedName;
import niteknightt.chess.lichessapi.LichessAccountEnums;
import niteknightt.chess.lichessapi.LichessApiObject;
import niteknightt.chess.lichessapi.LichessUsersEnums;

import java.util.Map;

/**
 * Light account profile on Lichess.
 */
public class LightUserProfile extends LichessApiObject {

    /**
     * Internal ID used by Lichess.
     */
    public String id;

    /**
     * Username that is displayed.
     */
    public String name;

    /**
     * Flair used by the user.
     */
    public String flair;

    /**
     * User's title or bot indicator.
     */
    public LichessAccountEnums.Title title;

    /**
     * Color of the user's wings if the user is a patron.
     */
    public int patronColor;
}
