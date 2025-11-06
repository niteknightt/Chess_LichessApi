package niteknightt.chess.lichessapi;

import niteknightt.chess.common.AppLogger;
import niteknightt.chess.common.Enums;
import niteknightt.chess.common.Settings;
import niteknightt.chess.lichessapi.functions.Users;
import niteknightt.chess.lichessapi.objects.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class UsersTest {

    @Test
    public void testGetRealTimeUserStatus() {
        String userForTest1 = "elihaber";
        String[] usersForTest2 = {"elihaber", "niteknightt"};
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        UserStatus[] userStatus1 = Users.getRealTimeUserStatus(userForTest1, true);
        UserStatus[] userStatus2 = Users.getRealTimeUserStatus(Arrays.asList(usersForTest2), true);
        System.out.println("sdf");
    }

    @Test
    public void testGetAllTopTen() {
        String userForTest1 = "elihaber";
        String[] usersForTest2 = {"elihaber", "niteknightt"};
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        Map<LichessUsersEnums.VariantKey, ShortUserProfile[]> topTen = Users.getAllTopTen();
        System.out.println("sdf");
    }

    @Test
    public void testGetOneLeaderboard() {
        String userForTest1 = "elihaber";
        String[] usersForTest2 = {"elihaber", "niteknightt"};
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        Map<LichessUsersEnums.VariantKey, ShortUserProfile[]> topTen = Users.getAllTopTen();
        System.out.println("sdf");
    }

    @Test
    public void testGetUserPublicData() {
        String userForTest1 = "elihaber";
        String[] usersForTest2 = {"elihaber", "niteknightt"};
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        UserProfile profile = Users.getUserPublicData("ted320", true);
        System.out.println("sdf");
    }

    @Test
    public void testGetUserRatingHistory() {
        String userForTest1 = "elihaber";
        String[] usersForTest2 = {"elihaber", "niteknightt"};
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        UserRatingHistory[] ratingHistory = Users.getUserRatingHistory("ted320");
        Map<Date, Integer> ratings = ratingHistory[0].getRatings();
        System.out.println("sdf");
    }

    @Test
    public void testGetUserPerfStats() {
        String userForTest1 = "elihaber";
        String[] usersForTest2 = {"elihaber", "niteknightt"};
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        UserPerfStats perfStats = Users.getUserPerfStats("elihaber", LichessUsersEnums.PerfVariant.RAPID);
        System.out.println("sdf");
    }

}
