import niteknightt.chess.common.AppLogger;
import niteknightt.chess.common.Enums;
import niteknightt.chess.common.Settings;
import niteknightt.chess.lichessapi.LichessInterface;
import niteknightt.chess.lichessapi.LichessUserList;
import org.junit.jupiter.api.Test;

public class TestTest {

    @Test
    public void testTest() {
        Settings.createInstance(Enums.SettingsType.BOTTERBOT);
        AppLogger.createInstance(Enums.SettingsType.NITEKNIGHTTBOT, Enums.LogLevel.DEBUG, true);
        LichessUserList userlist =  LichessInterface.autocompleteUsernames("aaa");
        System.out.println("At end");
    }
}
