package niteknightt.chess.lichessapi;

import niteknightt.chess.common.AppLogger;
import niteknightt.chess.common.Enums;
import niteknightt.chess.common.Settings;
import niteknightt.chess.lichessapi.functions.Account;
import niteknightt.chess.lichessapi.objects.Timeline;
import niteknightt.chess.lichessapi.objects.PrefsAndLang;
import niteknightt.chess.lichessapi.objects.UserProfile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testGetMyProfile() {
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        UserProfile userProfile = Account.getMyProfile();
        Assertions.assertEquals("elihaber", userProfile.id);
        Assertions.assertEquals("EliHaber", userProfile.username);
    }

    @Test
    public void testGetMyEmailAddress() {
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        String email = Account.getMyEmailAddress();
        Assertions.assertEquals("ehli@adar10.com", email);
    }

    @Test
    public void testGetMyPreferences() {
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        PrefsAndLang prefsAndLang = Account.getMyPreferences();
        Assertions.assertEquals("en-US", prefsAndLang.language);
        Assertions.assertEquals(1, prefsAndLang.prefs.clockTenths);
        Assertions.assertEquals(1, prefsAndLang.prefs.takeback);
    }

    @Test
    public void testGetMyKidModeStatus() {
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        boolean kidModeStatus = Account.getMyKidModeStatus();
        Assertions.assertEquals(false, kidModeStatus);
    }

    @Test
    public void testSetMyKidModeStatus() {
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        boolean origStatus = Account.getMyKidModeStatus();
        boolean newStatus = !origStatus;
        Account.setMyKidModeStatus(newStatus);
        boolean confirmStatus = Account.getMyKidModeStatus();
        Assertions.assertEquals(newStatus, confirmStatus, "First status test failed");
        Account.setMyKidModeStatus(origStatus);
        confirmStatus = Account.getMyKidModeStatus();
        Assertions.assertEquals(origStatus, confirmStatus, "Second status test failed");
    }

    @Test
    public void testGetMyTimeline() {
        // TODO: This test passes but does not return any data. Need to check.
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        Timeline timeline = Account.getMyTimeline(-1, 10);
        //1759347010000l
        //1356998400070l
    }

}
