package niteknightt.chess.lichessapi;

import niteknightt.chess.common.AppLogger;
import niteknightt.chess.common.Enums;
import niteknightt.chess.common.Settings;
import niteknightt.chess.lichessapi.functions.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import niteknightt.chess.lichessapi.objects.Account.*;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class AccountTest {

    @Test
    public void testGetMyProfile() {
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        GetMyProfileResponse userProfile = Account.getMyProfile();

        Assertions.assertEquals("elihaber", userProfile.getId());
        Assertions.assertEquals("https://lichess.org/@/EliHaber", userProfile.getUrl());
        Assertions.assertEquals("EliHaber", userProfile.getUsername());
        Assertions.assertEquals(false, userProfile.getBlocking());
        Assertions.assertNotNull(userProfile.getCount());
        Assertions.assertTrue(userProfile.getCount().getAll() > 1000 && userProfile.getCount().getAll() < 2000);
        Assertions.assertTrue(userProfile.getCount().getBookmark() > 0 && userProfile.getCount().getBookmark() < 20);
        Assertions.assertTrue(userProfile.getCount().getDraw() > 30 && userProfile.getCount().getDraw() < 50);
        Assertions.assertTrue(userProfile.getCount().getImport() > 15 && userProfile.getCount().getImport() < 40);
        Assertions.assertTrue(userProfile.getCount().getLoss() > 500 && userProfile.getCount().getLoss() < 1000);
        Assertions.assertTrue(userProfile.getCount().getMe() >= 0 && userProfile.getCount().getMe() < 10);
        Assertions.assertTrue(userProfile.getCount().getPlaying() >= 0 && userProfile.getCount().getPlaying() < 10);
        Assertions.assertTrue(userProfile.getCount().getRated() > 750 && userProfile.getCount().getRated() < 2000);
        Assertions.assertTrue(userProfile.getCount().getWin() > 450 && userProfile.getCount().getWin() < 1000);
        Assertions.assertTrue(userProfile.getCount().getDrawH() >= 0 && userProfile.getCount().getDrawH() < 10);
        Assertions.assertTrue(userProfile.getCount().getLossH() >= 0 && userProfile.getCount().getLossH() < 10);
        Assertions.assertTrue(userProfile.getCount().getWinH() >= 0 && userProfile.getCount().getWinH() < 10);

        TestHelper.testDate(userProfile.getCreatedAt(), "2019-12-18");

        Assertions.assertEquals(false, userProfile.getDisabled());
        Assertions.assertEquals("activity.lichess-horsey", userProfile.getFlair());
        Assertions.assertEquals(true, userProfile.getFollowable());
        Assertions.assertEquals(false, userProfile.getFollowing());
        Assertions.assertEquals(0, userProfile.getPatronColor());

        Assertions.assertNotNull(userProfile.getPerfs());

        Assertions.assertNotNull(userProfile.getPerfs().getAntichess());
        TestHelper.testNoActivityForVariant(userProfile.getPerfs().getAntichess());

        Assertions.assertNotNull(userProfile.getPerfs().getAtomic());
        TestHelper.testNoActivityForVariant(userProfile.getPerfs().getAtomic());

        Assertions.assertNotNull(userProfile.getPerfs().getBlitz());
        TestHelper.testVariantActivity(userProfile.getPerfs().getBlitz(),
                130, 300, -100, 100, 1000, 1500, 20, 100, false);

        Assertions.assertNotNull(userProfile.getPerfs().getBullet());
        TestHelper.testVariantActivity(userProfile.getPerfs().getBullet(),
                10, 30, -100, 100, 1000, 1500, 20, 200, true);

        Assertions.assertNotNull(userProfile.getPerfs().getChess960());
        TestHelper.testNoActivityForVariant(userProfile.getPerfs().getChess960());

        Assertions.assertNotNull(userProfile.getPerfs().getClassical());
        TestHelper.testVariantActivity(userProfile.getPerfs().getClassical(),
                2, 10, 0, 0, 1000, 1500, 20, 300, true);

        Assertions.assertNotNull(userProfile.getPerfs().getCorrespondence());
        TestHelper.testVariantActivity(userProfile.getPerfs().getCorrespondence(),
                0, 0, 0, 0, 1499, 1501, 499, 501, true);

        Assertions.assertNotNull(userProfile.getPerfs().getCrazyhouse());
        TestHelper.testNoActivityForVariant(userProfile.getPerfs().getCrazyhouse());

        Assertions.assertNotNull(userProfile.getPerfs().getHorde());
        TestHelper.testNoActivityForVariant(userProfile.getPerfs().getHorde());

        Assertions.assertNotNull(userProfile.getPerfs().getKingOfTheHill());
        TestHelper.testNoActivityForVariant(userProfile.getPerfs().getKingOfTheHill());

        Assertions.assertNotNull(userProfile.getPerfs().getPuzzle());
        TestHelper.testVariantActivity(userProfile.getPerfs().getPuzzle(),
                21000, 40000, -100, 100, 1800, 2800, 20, 100, false);

        Assertions.assertNotNull(userProfile.getPerfs().getRacer());
        Assertions.assertTrue(userProfile.getPerfs().getRacer().getRuns() > 70 && userProfile.getPerfs().getRacer().getRuns() < 300);
        Assertions.assertTrue(userProfile.getPerfs().getRacer().getScore() >= 40 && userProfile.getPerfs().getRacer().getScore() < 60);

        Assertions.assertNotNull(userProfile.getPerfs().getRacingKings());
        TestHelper.testNoActivityForVariant(userProfile.getPerfs().getRacingKings());

        Assertions.assertNotNull(userProfile.getPerfs().getRapid());
        TestHelper.testVariantActivity(userProfile.getPerfs().getRapid(),
                600, 2000, -30, 70, 1500, 2800, 20, 100, false);

        Assertions.assertNotNull(userProfile.getPerfs().getStorm());
        Assertions.assertTrue(userProfile.getPerfs().getStorm().getRuns() > 900 && userProfile.getPerfs().getStorm().getRuns() < 2000);
        Assertions.assertTrue(userProfile.getPerfs().getStorm().getScore() >= 30 && userProfile.getPerfs().getStorm().getScore() < 60);

        Assertions.assertNotNull(userProfile.getPerfs().getStreak());
        Assertions.assertTrue(userProfile.getPerfs().getStreak().getRuns() > 340 && userProfile.getPerfs().getStreak().getRuns() < 1000);
        Assertions.assertTrue(userProfile.getPerfs().getStreak().getScore() >= 42 && userProfile.getPerfs().getStreak().getScore() < 60);

        Assertions.assertNotNull(userProfile.getPerfs().getThreeCheck());
        TestHelper.testNoActivityForVariant(userProfile.getPerfs().getThreeCheck());

        Assertions.assertNotNull(userProfile.getPerfs().getUltraBullet());
        TestHelper.testNoActivityForVariant(userProfile.getPerfs().getUltraBullet());

        Assertions.assertEquals("", userProfile.getPlaying());
        Assertions.assertNotNull(userProfile.getPlayTime());
        Assertions.assertTrue(userProfile.getPlayTime().getTotal() > 714000 && userProfile.getPlayTime().getTotal() < 1200000);
        Assertions.assertEquals(0, userProfile.getPlayTime().getTv());
        Assertions.assertEquals(0, userProfile.getPlayTime().getHuman());
        Assertions.assertNotNull(userProfile.getProfile());
        Assertions.assertEquals("Shoop", userProfile.getProfile().getBio());
        Assertions.assertEquals(0, userProfile.getProfile().getCfcRating());
        Assertions.assertEquals(0, userProfile.getProfile().getDsbRating());
        Assertions.assertEquals(0, userProfile.getProfile().getEcfRating());
        Assertions.assertEquals(0, userProfile.getProfile().getFideRating());
        Assertions.assertEquals("US", userProfile.getProfile().getFlag());
        Assertions.assertEquals("https://myspace.com/eliwagarheim do not click", userProfile.getProfile().getLinks());
        Assertions.assertEquals("Living room", userProfile.getProfile().getLocation());
        Assertions.assertEquals(0, userProfile.getProfile().getRcfRating());
        Assertions.assertEquals("Umm no", userProfile.getProfile().getRealName());
        Assertions.assertEquals(0, userProfile.getProfile().getUscfRating());

        TestHelper.testDate(userProfile.getSeenAt(), "2026-01-01");

        Assertions.assertNotNull(userProfile.getStreamer());
        TestHelper.testNoStreaming(userProfile.getStreamer());

        Assertions.assertEquals(false, userProfile.getStreaming());
        Assertions.assertEquals(GetMyProfileTitle.NONE, userProfile.getTitle());
        Assertions.assertEquals(false, userProfile.getTosViolation());
        Assertions.assertEquals(false, userProfile.getVerified());
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
        GetMyPreferencesResponse preferences = Account.getMyPreferences();

        Assertions.assertEquals("en-US", preferences.getLanguage());

        // Piece animation: 0=none 1=fast 2=normal 3=slow
        Assertions.assertEquals(2, preferences.getPrefs().getAnimation());

        // Auto-promote to queen: 1=never 2=when premoving 3=always
        Assertions.assertEquals(2, preferences.getPrefs().getAutoQueen());

        // Auto-claim 3-fold repetition draw: 1=never 2=when time < 30 sec 3=always
        Assertions.assertEquals(2, preferences.getPrefs().getAutoThreefold());

        Assertions.assertEquals("//lichess1.org/assets/images/background/landscape.jpg", preferences.getPrefs().getBgImg());

        // Appears to always be zero. Mode can be set per game/puzzle.
        Assertions.assertEquals(0, preferences.getPrefs().getBlindfold());

        // Value is true. Don't know what it is.
        Assertions.assertEquals(true, preferences.getPrefs().getCaptured());

        // Allow challenges: 1=never 2=if rating +-300 3=only friends 4=if registered 5=always
        Assertions.assertEquals(4, preferences.getPrefs().getChallenge());

        Assertions.assertEquals(true, preferences.getPrefs().getClockBar());

        Assertions.assertEquals(true, preferences.getPrefs().getClockSound());

        // Display 10th of second: 0=never 1=when time < 10 sec 2=always
        Assertions.assertEquals(1, preferences.getPrefs().getClockTenths());

        // Confirm resign and draw: 0=no 1=yes
        Assertions.assertEquals(1, preferences.getPrefs().getConfirmResign());

        // Display coordinates: 0=no 1=inside 2=outside 3=all squares
        Assertions.assertEquals(1, preferences.getPrefs().getCoords());

        // Background set to dark mode.
        Assertions.assertEquals(false, preferences.getPrefs().getDark());

        // Show piece destinations.
        Assertions.assertEquals(true, preferences.getPrefs().getDestination());

        // Show player flairs.
        Assertions.assertEquals(true, preferences.getPrefs().getFlairs());

        // Allow follows.
        Assertions.assertEquals(true, preferences.getPrefs().getFollow());

        // Highlight last move and check.
        Assertions.assertEquals(true, preferences.getPrefs().getHighlight());

        // Share insights with: 0=nobody 1=friends 2=everybody
        Assertions.assertEquals(1, preferences.getPrefs().getInsightShare());

        Assertions.assertEquals(false, preferences.getPrefs().getIs3D());

        // 0=no 1=yes
        Assertions.assertEquals(0, preferences.getPrefs().getKeyboardMove());

        // Let players message: 1=existing conversations 2=friends 3=always
        Assertions.assertEquals(3, preferences.getPrefs().getMessage());

        // Allow more time: 1=never 2=casual games 3=always
        Assertions.assertEquals(3, preferences.getPrefs().getMoretime());

        // Move piece: 0=click twice 1=drag 2=both
        Assertions.assertEquals(2, preferences.getPrefs().getMoveEvent());

        // Piece notation: 0=piece symbol 1=piece letter
        Assertions.assertEquals(1, preferences.getPrefs().getPieceNotation());

        Assertions.assertEquals(GetMyPreferencesPieceSet.cburnett, preferences.getPrefs().getPieceSet());

        Assertions.assertEquals(GetMyPreferencesPieceSet3d.Basic, preferences.getPrefs().getPieceSet3D());

        Assertions.assertEquals(true, preferences.getPrefs().getPremove());

        // Show player ratings: 0=no 1=yes 2=except in game
        Assertions.assertEquals(1, preferences.getPrefs().getRatings());

        // Value is 2. Don't know what it is.
        Assertions.assertEquals(2, preferences.getPrefs().getReplay());

        // Castling: 0=move king 2 squares 1=move king onto rook
        Assertions.assertEquals(1, preferences.getPrefs().getRookCastle());

        // Automatically say GG: 0=never 1=defeat 2=draw and defeat
        Assertions.assertEquals(0, preferences.getPrefs().getSayGG());

        Assertions.assertEquals(GetMyPreferencesSoundSet.standard, preferences.getPrefs().getSoundSet());

        // Confirm moves: binary unlimited/correspondence/classical/rapid/blitz
        Assertions.assertEquals(2, preferences.getPrefs().getSubmitMove());

        // Allow takebacks: 1=never 2=casual 3=always
        Assertions.assertEquals(1, preferences.getPrefs().getTakeback());

        Assertions.assertEquals("brown", preferences.getPrefs().getTheme());

        Assertions.assertEquals("Woodi", preferences.getPrefs().getTheme3D());

        // Value is false. Don't know what it is.
        Assertions.assertEquals(false, preferences.getPrefs().getTransp());

        Assertions.assertEquals(false, preferences.getPrefs().getVoiceMove());

        // Zen mode: 0=no 1=yes 2=in game only
        Assertions.assertEquals(2, preferences.getPrefs().getZen());
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
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        GetMyTimelineResponse timeline = Account.getMyTimeline(1356998400070l, 15);

        Assertions.assertNotNull(timeline);

        Assertions.assertEquals(1, timeline.getEntriesCount());

        for (int i = 0; i < timeline.getEntriesCount(); ++i) {
            TimelineEntry entry = timeline.getEntries(i);
            Assertions.assertEquals("plan-renew", entry.getType());
            Assertions.assertNotNull(entry.getData());
            Assertions.assertEquals("niteknightt", entry.getData().getUserId());
            Assertions.assertTrue(entry.getData().getMonths() > 15 && entry.getData().getMonths() < 40);
            String date = TestHelper.timestampToDateString(entry.getDate());
            int year = Integer.parseInt(date.substring(0, 4));
            Assertions.assertTrue(year > 1999 && year < 2030);
        }

        Map<String, TimelineUser> users = timeline.getUsersMap();

        Assertions.assertNotNull(users);
        Assertions.assertEquals(1, users.size());

        TimelineUser nnUser = users.get("niteknightt");

        Assertions.assertNotNull(nnUser);

        Assertions.assertEquals("niteknightt", nnUser.getId());
        Assertions.assertEquals("niteknightt", nnUser.getName());
        Assertions.assertEquals("nature.dog-face", nnUser.getFlair());
        Assertions.assertEquals(6, nnUser.getPatronColor());
        Assertions.assertEquals(GetMyProfileTitle.NONE, nnUser.getTitle());

    }

}
