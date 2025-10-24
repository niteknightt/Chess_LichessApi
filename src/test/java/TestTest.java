import niteknightt.chess.common.AppLogger;
import niteknightt.chess.common.Enums;
import niteknightt.chess.common.Settings;
import niteknightt.chess.lichessapi.LichessInterface;
import niteknightt.chess.lichessapi.LichessUserList;
import org.junit.jupiter.api.Test;

public class TestTest {

    @Test
    public void testTest() {
        try {
            Settings.createInstance(Enums.SettingsType.COMMON);
        }
        catch (Exception ex) {
            System.out.println(ex);
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
        try {
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        }
        catch (Exception ex) {
            System.out.println(ex);
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
        LichessUserList userlist =  LichessInterface.autocompleteUsernames("EliHa");
        System.out.println("At end");
    }
}
