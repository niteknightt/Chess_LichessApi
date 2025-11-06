package niteknightt.chess.lichessapi.functions;

import com.google.gson.reflect.TypeToken;
import niteknightt.chess.lichessapi.LichessInterface;
import niteknightt.chess.lichessapi.LichessUsersEnums;
import niteknightt.chess.lichessapi.objects.*;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Users {

    public static Type userStatusArray = UserStatus[].class;
    public static Type shortUserProfileMap = new TypeToken<Map<LichessUsersEnums.VariantKey, ShortUserProfile[]>>(){}.getType();

    /**
     * Builds the endpoint for the getRealTimeUserStatus* functions. Each specific
     * function can then add its own parameters to the endpoint at the end.
     *
     * @param users
     * @param withSignal
     * @return
     */
    private static String buildBasicEndpoint(List<String> users, boolean withSignal) {
        if (users == null || users.size() == 0) {
            return null;
        }
        String endpoint = "users/status?ids=";
        boolean firstUserAdded = false;
        for (String user : users) {
            if (firstUserAdded) {
                endpoint += ",";
            }
            endpoint += user;
            firstUserAdded = true;
        }
        endpoint += "&withSignal=" + (withSignal ? "true" : "false");

        return endpoint;
    }

    public static UserStatus[] getRealTimeUserStatus(String user) {
        return getRealTimeUserStatus(Arrays.asList(user));
    }

    public static UserStatus[] getRealTimeUserStatus(String user, boolean withSignal) {
        return getRealTimeUserStatus(Arrays.asList(user), withSignal);
    }

    public static UserStatus[] getRealTimeUserStatus(List<String> users) {
        return getRealTimeUserStatus(users, false);
    }

    public static UserStatus[] getRealTimeUserStatus(List<String> users, boolean withSignal) {
        String endpoint = buildBasicEndpoint(users, withSignal);
        return LichessInterface.httpSyncGetWrapper(endpoint, userStatusArray);
    }

    public static UserStatus[] getRealTimeUserStatusWithGameIds(String user) {
        return getRealTimeUserStatusWithGameIds(Arrays.asList(user));
    }

    public static UserStatus[] getRealTimeUserStatusWithGameIds(String user, boolean withSignal) {
        return getRealTimeUserStatusWithGameIds(Arrays.asList(user), withSignal);
    }

    public static UserStatus[] getRealTimeUserStatusWithGameIds(List<String> users) {
        return getRealTimeUserStatusWithGameIds(users, false);
    }

    public static UserStatus[] getRealTimeUserStatusWithGameIds(List<String> users, boolean withSignal) {
        String endpoint = buildBasicEndpoint(users, withSignal);
        endpoint += "&withGameIds=true";
        return LichessInterface.httpSyncGetWrapper(endpoint, userStatusArray);
    }

    public static UserStatus[] getRealTimeUserStatusWithGameMetas(String user) {
        return getRealTimeUserStatusWithGameMetas(Arrays.asList(user));
    }

    public static UserStatus[] getRealTimeUserStatusWithGameMetas(String user, boolean withSignal) {
        return getRealTimeUserStatusWithGameMetas(Arrays.asList(user), withSignal);
    }

    public static UserStatus[] getRealTimeUserStatusWithGameMetas(List<String> users) {
        return getRealTimeUserStatusWithGameMetas(users, false);
    }

    public static UserStatus[] getRealTimeUserStatusWithGameMetas(List<String> users, boolean withSignal) {
        String endpoint = buildBasicEndpoint(users, withSignal);
        endpoint += "&withGameMetas=true";
        return LichessInterface.httpSyncGetWrapper(endpoint, userStatusArray);
    }

    public static Map<LichessUsersEnums.VariantKey, ShortUserProfile[]> getAllTopTen() {
        return (Map<LichessUsersEnums.VariantKey, ShortUserProfile[]>)LichessInterface.httpSyncGetWrapper("player", shortUserProfileMap);
    }

    public static Leaderboard getOneLeaderboard(int numUsers, LichessUsersEnums.VariantKey chessVariant) {
        return LichessInterface.httpSyncGetWrapper("player/top/" + numUsers + "/" + LichessUsersEnums.variantKeyText(chessVariant), shortUserProfileMap);
    }

    /**
     * Returns the profile of a user.
     * Note that trophies is not supported until I figure out how it is represented
     * in the returned data. So far every time I have requested trophies I just get
     * an empty list. So for now the URL will not have trophies enabled, even if
     * the parameter is set to true.
     *
     * @param username the user who's profile to return.
     * @param trophies flag whether to include the user's trophies. Currently does
     *                 nothing.
     * @return profile of the requested user.
     */
    public static UserProfile getUserPublicData(String username, boolean trophies) {
        return LichessInterface.httpSyncGetWrapper("user/" + username + "?trophies=false", UserProfile.class);
    }

    public static UserRatingHistory[] getUserRatingHistory(String username) {
        return LichessInterface.httpSyncGetWrapper("user/" + username + "/rating-history", UserRatingHistory[].class);
    }

    public static UserPerfStats getUserPerfStats(String username, LichessUsersEnums.PerfVariant variant) {
        return LichessInterface.httpSyncGetWrapper("user/" + username + "/perf/" + LichessUsersEnums.perfVariantText(variant), UserPerfStats.class);
    }
}
