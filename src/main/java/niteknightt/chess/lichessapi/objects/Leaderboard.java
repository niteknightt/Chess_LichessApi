package niteknightt.chess.lichessapi.objects;

import com.google.gson.annotations.SerializedName;
import niteknightt.chess.lichessapi.LichessAccountEnums;
import niteknightt.chess.lichessapi.LichessApiObject;
import niteknightt.chess.lichessapi.LichessUsersEnums;

import java.util.List;
import java.util.Map;

/**
 * List of top users in a chess variant.
 */
public class Leaderboard extends LichessApiObject {

    /**
     * Top users in the given variant.
     */
    public List<ShortUserProfile> users;
}
