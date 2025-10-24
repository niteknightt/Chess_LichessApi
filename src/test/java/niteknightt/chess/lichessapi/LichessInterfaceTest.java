package niteknightt.chess.lichessapi;

import niteknightt.chess.common.AppLogger;
import niteknightt.chess.common.Enums;
import niteknightt.chess.common.Settings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LichessInterfaceTest {

    @Test
    public void testGetProfile() {
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        LichessProfile lichessProfile = LichessInterface.getProfile();
        Assertions.assertEquals("elihaber", lichessProfile.id);
        Assertions.assertEquals("EliHaber", lichessProfile.username);
        //lichessProfile.

    }
}
