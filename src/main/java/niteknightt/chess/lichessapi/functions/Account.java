package niteknightt.chess.lichessapi.functions;

import niteknightt.chess.lichessapi.*;
import niteknightt.chess.lichessapi.objects.Account.*;

public class Account {

    public static GetMyProfileResponse getMyProfile() {
        return LichessInterface.httpSyncGetWrapper("account", new StandardJsonParser<>(GetMyProfileResponse.class));
    }

    public static String getMyEmailAddress() {
        GetMyEmailAddressResponse email = LichessInterface.httpSyncGetWrapper("account/email", new StandardJsonParser<>(GetMyEmailAddressResponse.class));
        return email.getEmail() == null ? null : email.getEmail();
    }

    public static GetMyPreferencesResponse getMyPreferences() {
        GetMyPreferencesResponse prefs =  LichessInterface.httpSyncGetWrapper("account/preferences", new StandardJsonParser<>(GetMyPreferencesResponse.class));
        return prefs;
    }

    public static boolean getMyKidModeStatus() {
        GetMyKidModeStatusResponse kidModeStatus = LichessInterface.httpSyncGetWrapper("account/kid", new StandardJsonParser<>(GetMyKidModeStatusResponse.class));
        return kidModeStatus == null ? false : kidModeStatus.getKid();
    }

    public static boolean setMyKidModeStatus(boolean val) {
        return LichessInterface.doHttpSyncPost("account/kid?v=" + val);
    }

    public static GetMyTimelineResponse getMyTimeline(long fromTimestamp, int numEvents) {
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
        return LichessInterface.httpSyncGetWrapper(endpoint, new StandardJsonParser<>(GetMyTimelineResponse.class));
    }
}
