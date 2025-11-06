package niteknightt.chess.lichessapi;

import niteknightt.chess.common.AppLogger;
import niteknightt.chess.common.Enums;
import niteknightt.chess.common.Settings;
import niteknightt.chess.lichessapi.objects.UserProfile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LichessInterfaceTest {

    @Test
    public void testGetProfile() {
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        UserProfile userProfile = LichessInterface.getProfile();
        Assertions.assertEquals("elihaber", userProfile.id);
        Assertions.assertEquals("EliHaber", userProfile.username);
        //lichessProfile.

    }

    @Test
    public void testGetUserPublicData() {
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        UserProfile userProfile = LichessInterface.getUserPublicData("elihaber");
        Assertions.assertEquals("elihaber", userProfile.id);
        Assertions.assertEquals("EliHaber", userProfile.username);
    }
}
