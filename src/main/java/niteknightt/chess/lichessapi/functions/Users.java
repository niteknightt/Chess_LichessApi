package niteknightt.chess.lichessapi.functions;

import com.google.gson.reflect.TypeToken;
import niteknightt.chess.lichessapi.GsonTypeParser;
import niteknightt.chess.lichessapi.LichessInterface;
import niteknightt.chess.lichessapi.LichessUsersEnums;
import niteknightt.chess.lichessapi.StandardJsonParser;
import niteknightt.chess.lichessapi.objects.*;
import niteknightt.chess.lichessapi.objects.Users.*;
import niteknightt.chess.lichessapi.objects.Account.*;

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

    public static GetRealTimeUserStatusResponse getRealTimeUserStatus(String user) {
        return getRealTimeUserStatus(Arrays.asList(user));
    }

    public static GetRealTimeUserStatusResponse getRealTimeUserStatus(String user, boolean withSignal) {
        return getRealTimeUserStatus(Arrays.asList(user), withSignal);
    }

    public static GetRealTimeUserStatusResponse getRealTimeUserStatus(List<String> users) {
        return getRealTimeUserStatus(users, false);
    }

    public static GetRealTimeUserStatusResponse getRealTimeUserStatus(List<String> users, boolean withSignal) {
        String endpoint = buildBasicEndpoint(users, withSignal);
        return LichessInterface.httpSyncGetWrapper(endpoint, new StandardJsonParser<>(GetRealTimeUserStatusResponse.class, true, "GetRealTimeUserStatus"));
    }

    public static GetRealTimeUserStatusResponse getRealTimeUserStatusWithGameIds(String user) {
        return getRealTimeUserStatusWithGameIds(Arrays.asList(user));
    }

    public static GetRealTimeUserStatusResponse getRealTimeUserStatusWithGameIds(String user, boolean withSignal) {
        return getRealTimeUserStatusWithGameIds(Arrays.asList(user), withSignal);
    }

    public static GetRealTimeUserStatusResponse getRealTimeUserStatusWithGameIds(List<String> users) {
        return getRealTimeUserStatusWithGameIds(users, false);
    }

    public static GetRealTimeUserStatusResponse getRealTimeUserStatusWithGameIds(List<String> users, boolean withSignal) {
        String endpoint = buildBasicEndpoint(users, withSignal);
        endpoint += "&withGameIds=true";
        return LichessInterface.httpSyncGetWrapper(endpoint, new StandardJsonParser<>(GetRealTimeUserStatusResponse.class));
    }

    public static GetRealTimeUserStatusResponse getRealTimeUserStatusWithGameMetas(String user) {
        return getRealTimeUserStatusWithGameMetas(Arrays.asList(user));
    }

    public static GetRealTimeUserStatusResponse getRealTimeUserStatusWithGameMetas(String user, boolean withSignal) {
        return getRealTimeUserStatusWithGameMetas(Arrays.asList(user), withSignal);
    }

    public static GetRealTimeUserStatusResponse getRealTimeUserStatusWithGameMetas(List<String> users) {
        return getRealTimeUserStatusWithGameMetas(users, false);
    }

    public static GetRealTimeUserStatusResponse getRealTimeUserStatusWithGameMetas(List<String> users, boolean withSignal) {
        String endpoint = buildBasicEndpoint(users, withSignal);
        endpoint += "&withGameMetas=true";
        return LichessInterface.httpSyncGetWrapper(endpoint, new StandardJsonParser<>(GetRealTimeUserStatusResponse.class, true, "GetRealTimeUserStatus"));
    }

    public static GetAllTopTenResponse getAllTopTen() {
        return LichessInterface.httpSyncGetWrapper("player", new StandardJsonParser<>(GetAllTopTenResponse.class));
    }

    public static GetOneLeaderboardResponse getOneLeaderboard(int numUsers, LichessUsersEnums.VariantKey chessVariant) {
        return LichessInterface.httpSyncGetWrapper("player/top/" + numUsers + "/" + LichessUsersEnums.variantKeyText(chessVariant), new StandardJsonParser<>(GetOneLeaderboardResponse.class));
    }

    /**
     * Returns the profile of a user.
     * Note that trophies is not supported until I figure out how it is represented
     * in the returned data. So far every time I have requested trophies I just get
     * an empty list. So for now the URL will not have trophies enabled, even if
     * the parameter is set to true.
     *
     * @param username the user who's profile to return.
     * @param trophies flag whether to include the user's trophies.
     * @param profile flag whether to include the user's profile.
     * @param rank flag whether to include the user's rank.
     * @return profile of the requested user.
     */
    public static GetMyProfileResponse getUserPublicData(String username, boolean trophies, boolean profile, boolean rank) {
        return LichessInterface.httpSyncGetWrapper("user/" + username + "?trophies=" + trophies + "&profile=" + profile + "&rank=" + rank, new StandardJsonParser<>(GetMyProfileResponse.class));
    }

    public static GetMyProfileResponse getUserPublicData(String username) {
        return getUserPublicData(username, false, false, false);
    }

    public static GetMyProfileResponse getUserPublicDataWithTrophies(String username) {
        return getUserPublicData(username, true, false, false);
    }

    public static GetMyProfileResponse getUserPublicDataWithProfile(String username) {
        return getUserPublicData(username, false, true, false);
    }

    public static GetMyProfileResponse getUserPublicDataWithRank(String username) {
        return getUserPublicData(username, false, false, true);
    }

    public static GetMyProfileResponse getUserPublicDataWithTrophiesAndProfile(String username) {
        return getUserPublicData(username, true, true, false);
    }

    public static GetMyProfileResponse getUserPublicDataWithTrophiesAndRank(String username) {
        return getUserPublicData(username, true, false, true);
    }

    public static GetMyProfileResponse getUserPublicDataWithProfileAndRank(String username) {
        return getUserPublicData(username, false, true, true);
    }

    public static GetMyProfileResponse getUserPublicDataWithAll(String username) {
        return getUserPublicData(username, true, true, true);
    }

    public static GetUserRatingHistoryResponse getUserRatingHistory(String username) {
            return LichessInterface.httpSyncGetWrapper("user/" + username + "/rating-history", new StandardJsonParser<>(GetUserRatingHistoryResponse.class, true, "GetUserRatingHistory"));
    }

    public static GetUserPerfStatsResponse getUserPerfStats(String username, LichessUsersEnums.PerfVariant variant) {
        return LichessInterface.httpSyncGetWrapper("user/" + username + "/perf/" + LichessUsersEnums.perfVariantText(variant), new StandardJsonParser<>(GetUserPerfStatsResponse.class));
    }
}
