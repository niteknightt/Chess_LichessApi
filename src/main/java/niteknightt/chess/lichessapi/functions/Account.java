package niteknightt.chess.lichessapi.functions;

import niteknightt.chess.lichessapi.*;
import niteknightt.chess.lichessapi.objects.*;

public class Account {

    public static UserProfile getMyProfile() {
        return (UserProfile) LichessInterface.httpSyncGetWrapper("account", UserProfile.class);
    }

    public static String getMyEmailAddress() {
        Email email = (Email)LichessInterface.httpSyncGetWrapper("account/email", Email.class);
        return email == null ? null : email.email;
    }

    public static PrefsAndLang getMyPreferences() {
        return (PrefsAndLang)LichessInterface.httpSyncGetWrapper("account/preferences", PrefsAndLang.class);
    }

    public static boolean getMyKidModeStatus() {
        KidModeStatus kidModeStatus = (KidModeStatus)LichessInterface.httpSyncGetWrapper("account/kid", KidModeStatus.class);
        return kidModeStatus == null ? false : kidModeStatus.kid;
    }

    public static boolean setMyKidModeStatus(boolean val) {
        return LichessInterface.doHttpSyncPost("account/kid?v=" + val);
    }

    public static Timeline getMyTimeline(long fromTimestamp, int numEvents) {
        boolean timestampAdded = false;
        String endpoint = "timeline?";
        if (fromTimestamp != -1) {
            endpoint += "since=" + fromTimestamp;
            timestampAdded = true;
        }
        if (numEvents != -1) {
            endpoint += (timestampAdded ? "&" : "");
            endpoint += "nb=" + numEvents;
        }
        return (Timeline) LichessInterface.httpSyncGetWrapper(endpoint, Timeline.class);
    }
}
