package niteknightt.chess.lichessapi.objects;

import com.google.gson.annotations.SerializedName;
import niteknightt.chess.lichessapi.LichessAccountEnums;
import niteknightt.chess.lichessapi.LichessApiObject;
import niteknightt.chess.lichessapi.LichessUsersEnums;

import java.util.*;

/**
 * Rating history of a user.
 */
public class UserRatingHistory extends LichessApiObject {

    /**
     * Chess variant.
     */
    public LichessUsersEnums.VariantName name;

    /**
     * Date and rating.
     */
    public List<List<Integer>> points;

    public Map<Date, Integer> getRatings() {
        HashMap<Date, Integer> ratings = new HashMap<>();

        for (List<Integer> oneday : points) {
            Calendar c = Calendar.getInstance();
            c.set(oneday.get(0), oneday.get(1), oneday.get(2), 0, 0, 0);
            ratings.put(c.getTime(), oneday.get(3));
        }

        return ratings;
    }
}
