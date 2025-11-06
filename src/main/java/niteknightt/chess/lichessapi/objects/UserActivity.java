package niteknightt.chess.lichessapi.objects;

import com.google.gson.annotations.SerializedName;
import niteknightt.chess.lichessapi.LichessAccountEnums;
import niteknightt.chess.lichessapi.LichessApiObject;

import java.util.Map;

/**
 * Activity of a user.
 */
public class UserActivity extends LichessApiObject {

    /**
     * The interval of time that these activities occurred in.
     */
    Interval interval;

}
