package niteknightt.chess.lichessapi;

import niteknightt.chess.common.AppLogger;
import niteknightt.chess.common.Enums;
import niteknightt.chess.common.Settings;
import niteknightt.chess.lichessapi.functions.Users;
import niteknightt.chess.lichessapi.objects.*;
import niteknightt.chess.lichessapi.objects.TimelineUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import niteknightt.chess.lichessapi.objects.Users.*;
import niteknightt.chess.lichessapi.objects.Account.*;

public class UsersTest {

    @Test
    public void testGetRealTimeUserStatus() {
        String userForTest1 = "elihaber";
        String[] usersForTest2 = {"elihaber", "niteknightt"};
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        GetRealTimeUserStatusResponse userStatus1 = Users.getRealTimeUserStatus(userForTest1, true);
        GetRealTimeUserStatusResponse userStatus2 = Users.getRealTimeUserStatus(Arrays.asList(usersForTest2), true);

        Assertions.assertNotNull(userStatus1);

        List<RealTimeUserStatus> statuses = userStatus1.getStatusesList();
        Assertions.assertNotNull(statuses);
        Assertions.assertEquals(1, statuses.size());

        RealTimeUserStatus status = statuses.get(0);
        Assertions.assertEquals("elihaber", status.getId());
        Assertions.assertEquals("EliHaber", status.getName());
        Assertions.assertEquals("activity.lichess-horsey", status.getFlair());
        Assertions.assertEquals("", status.getPlaying());
        Assertions.assertEquals(false, status.getStreaming());
        Assertions.assertEquals(Account.GetMyProfileTitle.NONE, status.getTitle());

        Assertions.assertNotNull(userStatus2);

        statuses = userStatus2.getStatusesList();
        Assertions.assertNotNull(statuses);
        Assertions.assertEquals(2, statuses.size());
        for (RealTimeUserStatus astatus : statuses) {
            if ("elihaber".equals(astatus.getId())) {
                Assertions.assertEquals("elihaber", astatus.getId());
                Assertions.assertEquals("EliHaber", astatus.getName());
                Assertions.assertEquals("activity.lichess-horsey", astatus.getFlair());
                Assertions.assertEquals("", astatus.getPlaying());
                Assertions.assertEquals(false, astatus.getStreaming());
                Assertions.assertEquals(Account.GetMyProfileTitle.NONE, astatus.getTitle());
            }
            else {
                Assertions.assertEquals("niteknightt", astatus.getId());
                Assertions.assertEquals("niteknightt", astatus.getName());
                Assertions.assertEquals("nature.dog-face", astatus.getFlair());
                Assertions.assertEquals(6, astatus.getPatronColor());
                Assertions.assertEquals("", astatus.getPlaying());
                Assertions.assertEquals(false, astatus.getStreaming());
                Assertions.assertEquals(Account.GetMyProfileTitle.NONE, astatus.getTitle());
            }
        }
    }

    public void testTopTenUser(GetAllTopTenUser user, String key) {
        Assertions.assertNotNull(user);
        Assertions.assertFalse(user.getId().isEmpty());
        Assertions.assertFalse(user.getUsername().isEmpty());
        Assertions.assertNotNull(user.getPerfs());
        Assertions.assertTrue(user.getPerfsOrThrow(key).getRating() > 0 && user.getPerfsOrThrow(key).getRating() < 10000);
        Assertions.assertTrue(user.getPerfsOrThrow(key).getProgress() > -10000 && user.getPerfsOrThrow(key).getProgress() < 10000);
    }

    public void testTopTenUsers(List<GetAllTopTenUser> users, String key) {
        Assertions.assertNotNull(users);
        Assertions.assertEquals(10, users.size());
        for (int i = 0; i < 10; ++i) {
            testTopTenUser(users.get(i), key);
        }
    }

    @Test
    public void testGetAllTopTen() {
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        GetAllTopTenResponse topTen = Users.getAllTopTen();

        Assertions.assertNotNull(topTen);

        List<GetAllTopTenUser> antichess = topTen.getAntichessList();
        testTopTenUsers(antichess, "antichess");

        List<GetAllTopTenUser> atomic = topTen.getAtomicList();
        testTopTenUsers(atomic, "atomic");

        List<GetAllTopTenUser> blitz = topTen.getBlitzList();
        testTopTenUsers(blitz, "blitz");

        List<GetAllTopTenUser> bullet = topTen.getBulletList();
        testTopTenUsers(bullet, "bullet");

        List<GetAllTopTenUser> chess960 = topTen.getChess960List();
        testTopTenUsers(chess960, "chess960");

        List<GetAllTopTenUser> classical = topTen.getClassicalList();
        testTopTenUsers(classical, "classical");

        List<GetAllTopTenUser> crazyhouse = topTen.getCrazyhouseList();
        testTopTenUsers(crazyhouse, "crazyhouse");

        List<GetAllTopTenUser> horde = topTen.getHordeList();
        testTopTenUsers(horde, "horde");

        List<GetAllTopTenUser> kingOfTheHill = topTen.getKingOfTheHillList();
        testTopTenUsers(kingOfTheHill, "kingOfTheHill");

        List<GetAllTopTenUser> racingKings = topTen.getRacingKingsList();
        testTopTenUsers(racingKings, "racingKings");

        List<GetAllTopTenUser> rapid = topTen.getRapidList();
        testTopTenUsers(rapid, "rapid");

        List<GetAllTopTenUser> threeCheck = topTen.getThreeCheckList();
        testTopTenUsers(threeCheck, "threeCheck");

        List<GetAllTopTenUser> ultraBullet = topTen.getUltraBulletList();
        testTopTenUsers(ultraBullet, "ultraBullet");
    }

    @Test
    public void testGetOneLeaderboard() {
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        int NUM_USERS = 12;
        LichessUsersEnums.VariantKey VARIANT = LichessUsersEnums.VariantKey.RAPID;
        GetOneLeaderboardResponse leaders = Users.getOneLeaderboard(NUM_USERS, VARIANT);

        Assertions.assertNotNull(leaders);
        Assertions.assertEquals(NUM_USERS, leaders.getUsersCount());
        for (int i = 0; i < NUM_USERS; ++i) {
            testTopTenUser(leaders.getUsers(i), LichessUsersEnums.variantKeyText(VARIANT));
        }
    }

    public void testBasicPublicData(GetMyProfileResponse userProfile) {
        Assertions.assertEquals("yuuki-asuna", userProfile.getId());
        Assertions.assertEquals("https://lichess.org/@/yuuki-asuna", userProfile.getUrl());
        Assertions.assertEquals("yuuki-asuna", userProfile.getUsername());
        Assertions.assertEquals(false, userProfile.getBlocking());
        Assertions.assertNotNull(userProfile.getCount());
        Assertions.assertTrue(userProfile.getCount().getAll() > 30000 && userProfile.getCount().getAll() < 50000);
        Assertions.assertTrue(userProfile.getCount().getBookmark() >= 0 && userProfile.getCount().getBookmark() <= 5);
        Assertions.assertTrue(userProfile.getCount().getDraw() > 2000 && userProfile.getCount().getDraw() < 2500);
        Assertions.assertTrue(userProfile.getCount().getImport() >= 0 && userProfile.getCount().getImport() <= 5);
        Assertions.assertTrue(userProfile.getCount().getLoss() >= 5500 && userProfile.getCount().getLoss() <= 10000);
        Assertions.assertTrue(userProfile.getCount().getMe() >= 0 && userProfile.getCount().getMe() <= 5);
        Assertions.assertTrue(userProfile.getCount().getPlaying() >= 0 && userProfile.getCount().getPlaying() < 300);
        Assertions.assertTrue(userProfile.getCount().getRated() > 30000 && userProfile.getCount().getRated() < 50000);
        Assertions.assertTrue(userProfile.getCount().getWin() > 20000 && userProfile.getCount().getWin() < 40000);
        Assertions.assertTrue(userProfile.getCount().getDrawH() >= 0 && userProfile.getCount().getDrawH() < 10);
        Assertions.assertTrue(userProfile.getCount().getLossH() >= 0 && userProfile.getCount().getLossH() < 10);
        Assertions.assertTrue(userProfile.getCount().getWinH() >= 0 && userProfile.getCount().getWinH() < 10);

        TestHelper.testDate(userProfile.getCreatedAt(), "2020-08-04");

        Assertions.assertEquals(false, userProfile.getDisabled());
        Assertions.assertEquals("symbols.broken-heart", userProfile.getFlair());
        Assertions.assertEquals(true, userProfile.getFollowable());
        Assertions.assertEquals(false, userProfile.getFollowing());
        Assertions.assertEquals(0, userProfile.getPatronColor());

        Assertions.assertNotNull(userProfile.getPerfs());

        Assertions.assertNotNull(userProfile.getPerfs().getAntichess());
        TestHelper.testVariantActivity(userProfile.getPerfs().getAntichess(),
                400, 1000, -100, 100, 2000, 2500, 20, 100, false);

        Assertions.assertNotNull(userProfile.getPerfs().getAtomic());
        TestHelper.testVariantActivity(userProfile.getPerfs().getAtomic(),
                800, 1500, -100, 100, 2000, 2500, 20, 100, false);

        Assertions.assertNotNull(userProfile.getPerfs().getBlitz());
        TestHelper.testVariantActivity(userProfile.getPerfs().getBlitz(),
                1300, 3000, -100, 100, 2400, 3000, 20, 100, false);

        Assertions.assertNotNull(userProfile.getPerfs().getBullet());
        TestHelper.testVariantActivity(userProfile.getPerfs().getBullet(),
                2000, 2500, -100, 100, 2800, 3200, 20, 200, false);

        Assertions.assertNotNull(userProfile.getPerfs().getChess960());
        TestHelper.testVariantActivity(userProfile.getPerfs().getChess960(),
                1000, 1500, -100, 100, 2000, 3000, 20, 200, false);

        Assertions.assertNotNull(userProfile.getPerfs().getClassical());
        TestHelper.testVariantActivity(userProfile.getPerfs().getClassical(),
                100, 500, -30, 100, 2500, 3500, 20, 100, false);

        Assertions.assertNotNull(userProfile.getPerfs().getCorrespondence());
        TestHelper.testVariantActivity(userProfile.getPerfs().getCorrespondence(),
                15000, 30000, -30, 100, 2000, 3000, 20, 100, false);

        Assertions.assertNotNull(userProfile.getPerfs().getCrazyhouse());
        TestHelper.testVariantActivity(userProfile.getPerfs().getCrazyhouse(),
                2000, 3000, -30, 100, 2000, 3000, 20, 100, false);

        Assertions.assertNotNull(userProfile.getPerfs().getHorde());
        TestHelper.testVariantActivity(userProfile.getPerfs().getHorde(),
                800, 2000, -30, 100, 2000, 3000, 20, 100, false);

        Assertions.assertNotNull(userProfile.getPerfs().getKingOfTheHill());
        TestHelper.testVariantActivity(userProfile.getPerfs().getKingOfTheHill(),
                1500, 3000, -30, 100, 2000, 3000, 20, 100, false);

        Assertions.assertNotNull(userProfile.getPerfs().getPuzzle());
        TestHelper.testNoActivityForVariant(userProfile.getPerfs().getPuzzle());

        Assertions.assertNotNull(userProfile.getPerfs().getRacer());
        Assertions.assertTrue(userProfile.getPerfs().getRacer().getRuns() > 200 && userProfile.getPerfs().getRacer().getRuns() < 300);
        Assertions.assertTrue(userProfile.getPerfs().getRacer().getScore() >= 90 && userProfile.getPerfs().getRacer().getScore() < 200);

        Assertions.assertNotNull(userProfile.getPerfs().getRacingKings());
        TestHelper.testVariantActivity(userProfile.getPerfs().getRacingKings(),
                200, 500, -30, 100, 2000, 2500, 20, 100, false);

        Assertions.assertNotNull(userProfile.getPerfs().getRapid());
        TestHelper.testVariantActivity(userProfile.getPerfs().getRapid(),
                200, 500, -30, 70, 2500, 3500, 20, 100, false);

        Assertions.assertNotNull(userProfile.getPerfs().getStorm());
        Assertions.assertTrue(userProfile.getPerfs().getStorm().getRuns() > 5 && userProfile.getPerfs().getStorm().getRuns() < 50);
        Assertions.assertTrue(userProfile.getPerfs().getStorm().getScore() >= 50 && userProfile.getPerfs().getStorm().getScore() < 100);

        Assertions.assertNotNull(userProfile.getPerfs().getStreak());
        TestHelper.testNoActivityForVariant(userProfile.getPerfs().getStreak());

        Assertions.assertNotNull(userProfile.getPerfs().getThreeCheck());
        TestHelper.testVariantActivity(userProfile.getPerfs().getThreeCheck(),
                1000, 2000, -30, 70, 2000, 3000, 20, 100, false);

        Assertions.assertNotNull(userProfile.getPerfs().getUltraBullet());
        TestHelper.testVariantActivity(userProfile.getPerfs().getUltraBullet(),
                2500, 4000, -30, 70, 2000, 3000, 20, 100, false);

        //Assertions.assertEquals("", userProfile.getPlaying());
        Assertions.assertNotNull(userProfile.getPlayTime());
        Assertions.assertTrue(userProfile.getPlayTime().getTotal() > 1500000 && userProfile.getPlayTime().getTotal() < 2000000);
        Assertions.assertTrue(userProfile.getPlayTime().getTv() > 450000 && userProfile.getPlayTime().getTv() < 1000000);
        Assertions.assertEquals(0, userProfile.getPlayTime().getHuman());

        TestHelper.testDate(userProfile.getSeenAt(), "2026-01-01");

        Assertions.assertNotNull(userProfile.getStreamer());
        TestHelper.testStreaming(userProfile.getStreamer(),
                "https://www.twitch.tv/gmchika",
                "https://www.youtube.com/channel/UCv_IZoSU6Ax8Gswc_7WQOkw/live");

        Assertions.assertEquals(false, userProfile.getStreaming());
        Assertions.assertEquals(GetMyProfileTitle.CM, userProfile.getTitle());
        Assertions.assertEquals(false, userProfile.getTosViolation());
        Assertions.assertEquals(false, userProfile.getVerified());
    }

    public void testPublicDataTrophies(GetMyProfileResponse userProfile) {
        int NUM_TROPHIES_EXPECTED = 14;

        Assertions.assertEquals(NUM_TROPHIES_EXPECTED, userProfile.getTrophiesCount());

        for (int i = 0; i < NUM_TROPHIES_EXPECTED; ++i) {
            GetMyProfileTrophy trophy = userProfile.getTrophies(i);
            Assertions.assertNotNull(trophy);
            String trophyType = trophy.getType();
            Assertions.assertNotNull(trophyType);
            Assertions.assertTrue(trophyType.equals("perfTop") || trophyType.startsWith("marathonTop"));
            if (trophy.getType().equals("perfTop")) {
                Assertions.assertFalse(trophy.getPerf().isEmpty());
                Assertions.assertTrue(trophy.getTop() > 0 && trophy.getTop() <= 100);
                Assertions.assertFalse(trophy.getName().isEmpty());
            }
            else {
                Assertions.assertFalse(trophy.getName().isEmpty());
                Assertions.assertTrue(trophy.getName().startsWith("Marathon "));
                Assertions.assertFalse(trophy.getIcon().isEmpty());
                Assertions.assertFalse(trophy.getUrl().isEmpty());
                String trophyDate = TestHelper.timestampToDateString(trophy.getDate());
                Assertions.assertTrue(trophyDate.startsWith("20"));
            }
        }
    }

    public void testPublicDataProfile(GetMyProfileResponse userProfile) {
        Assertions.assertNotNull(userProfile.getProfile());
        Assertions.assertTrue(userProfile.getProfile().getBio().startsWith("FIDE Candidate Master"));
        Assertions.assertEquals(0, userProfile.getProfile().getCfcRating());
        Assertions.assertEquals(0, userProfile.getProfile().getDsbRating());
        Assertions.assertEquals(0, userProfile.getProfile().getEcfRating());
        Assertions.assertTrue(userProfile.getProfile().getFideRating() > 2200 && userProfile.getProfile().getFideRating() < 2500);
        Assertions.assertEquals("TW", userProfile.getProfile().getFlag());
        Assertions.assertFalse(userProfile.getProfile().getLinks().isEmpty());
        Assertions.assertEquals("", userProfile.getProfile().getLocation());
        Assertions.assertEquals(0, userProfile.getProfile().getRcfRating());
        Assertions.assertTrue(userProfile.getProfile().getRealName().startsWith("Joseph Wan"));
        Assertions.assertTrue(userProfile.getProfile().getUscfRating() > 2200 && userProfile.getProfile().getUscfRating() < 2500);
    }

    public void testPublicDataRank(GetMyProfileResponse userProfile) {
        TestHelper.testVariantRank(userProfile.getPerfs().getUltraBullet(), 80, 150);
        TestHelper.testVariantRank(userProfile.getPerfs().getBullet(), 450, 600);
        TestHelper.testVariantRank(userProfile.getPerfs().getBlitz(), 1500, 2500);
        TestHelper.testVariantRank(userProfile.getPerfs().getRapid(), 1, 150);
        TestHelper.testVariantRank(userProfile.getPerfs().getChess960(), 10, 50);
        TestHelper.testVariantRank(userProfile.getPerfs().getKingOfTheHill(), 5, 25);
        TestHelper.testVariantRank(userProfile.getPerfs().getThreeCheck(), 10, 25);
        TestHelper.testVariantRank(userProfile.getPerfs().getAntichess(), 350, 500);
        TestHelper.testVariantRank(userProfile.getPerfs().getAtomic(), 20, 60);
        TestHelper.testVariantRank(userProfile.getPerfs().getHorde(), 20, 40);
        TestHelper.testVariantRank(userProfile.getPerfs().getRacingKings(), 100, 150);
        TestHelper.testVariantRank(userProfile.getPerfs().getCrazyhouse(), 15, 40);
    }

    @Test
    public void testGetUserPublicData() {
        String userForTest1 = "elihaber";
        String[] usersForTest2 = {"elihaber", "niteknightt"};
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);

        // Test 1: No additional data
        GetMyProfileResponse publicData = Users.getUserPublicData("yuuki-asuna");
        testBasicPublicData(publicData);
        publicData = Users.getUserPublicDataWithAll("yuuki-asuna");
        testBasicPublicData(publicData);
        testPublicDataTrophies(publicData);
        testPublicDataProfile(publicData);
        testPublicDataRank(publicData);
    }

    @Test
    public void testGetUserRatingHistory() {
        String userForTest1 = "elihaber";
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);

        String[] variants = { "UltraBullet", "Bullet", "Blitz", "Rapid",
                "Classical", "Correspondence", "Crazyhouse",
                "Chess960", "King of the Hill", "Three-Check",
                "Antichess", "Atomic", "Horde", "Racing Kings",
                "Puzzles" };


        GetUserRatingHistoryResponse ratingHistory = Users.getUserRatingHistory("ted320");

        Assertions.assertNotNull(ratingHistory);

        Assertions.assertTrue(ratingHistory.getRatingHistoryCount() > 0);

        for (int i = 0; i < ratingHistory.getRatingHistoryCount(); ++i) {
            VariantRatingHistory variantRatingHistory =  ratingHistory.getRatingHistory(i);

            String variant = variantRatingHistory.getName();
            Assertions.assertTrue(Arrays.asList(variants).contains(variant));

            for (int j = 0; j < variantRatingHistory.getPointsCount(); ++j) {
                HistoricalPoints points = variantRatingHistory.getPoints(j);
                Assertions.assertTrue(points.getYear() >= 2000 && points.getYear() <= 2026);
                Assertions.assertTrue(points.getMonth() >= 1 && points.getMonth() <= 12);
                Assertions.assertTrue(points.getDay() >= 1 && points.getDay() <= 31);
                Assertions.assertTrue(points.getValue() >= 0 && points.getValue() <= 3500);
            }
        }
    }

    @Test
    public void testGetUserPerfStats() {
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        GetUserPerfStatsResponse perfStats = Users.getUserPerfStats("elihaber", LichessUsersEnums.PerfVariant.RAPID);

        Assertions.assertNotNull(perfStats);

        TestHelper.testRange(perfStats.getPercentile(), 60.0f, 65.0f);
        TestHelper.testRange(perfStats.getRank(), 100000, 150000);

        PerfStatsPerf perf = perfStats.getPerf();
        Assertions.assertNotNull(perf);

        TestHelper.testRange(perf.getNb(), 630, 700);
        TestHelper.testRange(perf.getProgress(), -50, 50);

        PerfStatsPerfDetails perfDetails = perf.getGlicko();
        Assertions.assertNotNull(perfDetails);

        TestHelper.testRange(perfDetails.getRating(), 1500, 1600);
        TestHelper.testRange(perfDetails.getDeviation(), 20, 60);
        Assertions.assertFalse(perfDetails.getProvisional());

        PerfStatsStats stats = perfStats.getStat();
        Assertions.assertNotNull(stats);

        PerfStatsBestWorst best = stats.getBestWins();
        Assertions.assertNotNull(best);

        List<PerfStatsResults> results = best.getResultsList();
        Assertions.assertNotNull(results);
        Assertions.assertEquals(5, results.size());
        PerfStatsResults top = results.get(0);
        Assertions.assertNotNull(top);
        long millis = top.getAt().getSeconds() * 1000L + top.getAt().getNanos() / 1_000_000L;
        String date = TestHelper.timestampToDateString(millis);
        Assertions.assertEquals("2025", date.substring(0, 4));
        Assertions.assertEquals("10", date.substring(5, 7));
        Assertions.assertEquals("09", date.substring(8, 10));
        Assertions.assertEquals("5iwkYWhm", top.getGameId());
        Assertions.assertEquals(1657, top.getOpRating());

        Account.TimelineUser op = top.getOpId();
        Assertions.assertNotNull(op);
        Assertions.assertEquals("anantasuri01", op.getId());

        PerfStatsBestWorst worst = stats.getWorstLosses();
        Assertions.assertNotNull(worst);

        results = worst.getResultsList();
        Assertions.assertNotNull(results);
        Assertions.assertEquals(5, results.size());
        top = results.get(0);
        Assertions.assertNotNull(top);
        millis = top.getAt().getSeconds() * 1000L + top.getAt().getNanos() / 1_000_000L;
        date = TestHelper.timestampToDateString(millis);
        Assertions.assertEquals("2020", date.substring(0, 4));
        Assertions.assertEquals("12", date.substring(5, 7));
        Assertions.assertEquals("04", date.substring(8, 10));
        Assertions.assertEquals("XEhTgLV0", top.getGameId());
        Assertions.assertEquals(873, top.getOpRating());

        op = top.getOpId();
        Assertions.assertNotNull(op);
        Assertions.assertEquals("louieking25", op.getId());

        PerfStatsCounts counts = stats.getCount();
        Assertions.assertNotNull(counts);
        TestHelper.testRange(counts.getAll(), 640, 800);
        Assertions.assertEquals(0, counts.getBerserk());
        Assertions.assertEquals(1, counts.getDisconnects());
        TestHelper.testRange(counts.getDraw(), 20, 40);
        TestHelper.testRange(counts.getLoss(), 300, 400);
        TestHelper.testRange(counts.getOpAvg(), 1400.0f, 1450.0f);
        TestHelper.testRange(counts.getRated(), 630, 800);
        TestHelper.testRange(counts.getSeconds(), 622000, 700000);
        TestHelper.testRange(counts.getTour(), 240, 300);
        TestHelper.testRange(counts.getWin(), 310, 400);

        PerfStatsPlayStreak playStreak = stats.getPlayStreak();
        Assertions.assertNotNull(playStreak);
        PerfStatsStreakInfo playStreakNb = playStreak.getNb();
        Assertions.assertNotNull(playStreakNb);
        PerfStatsStreakDetails nbCur = playStreakNb.getCur();
        Assertions.assertNotNull(nbCur);
        Assertions.assertEquals(0, nbCur.getV());
        PerfStatsStreakDetails nbMax = playStreakNb.getMax();
        Assertions.assertNotNull(nbMax);
        Assertions.assertEquals(8, nbMax.getV());
        PerfStatsResults nbMaxResultsFrom = nbMax.getFrom();
        Assertions.assertNotNull(nbMaxResultsFrom);
        millis = nbMaxResultsFrom.getAt().getSeconds() * 1000L + nbMaxResultsFrom.getAt().getNanos() / 1_000_000L;
        date = TestHelper.timestampToDateTimeString(millis);
        Assertions.assertEquals("2025", date.substring(0, 4));
        Assertions.assertEquals("04", date.substring(5, 7));
        Assertions.assertEquals("14", date.substring(8, 10));
        Assertions.assertEquals("14", date.substring(11, 13));
        Assertions.assertEquals("40", date.substring(14, 16));
        Assertions.assertEquals("zxsh2Zo6", nbMaxResultsFrom.getGameId());
        PerfStatsResults nbMaxResultsTo = nbMax.getTo();
        Assertions.assertNotNull(nbMaxResultsTo);
        millis = nbMaxResultsTo.getAt().getSeconds() * 1000L + nbMaxResultsTo.getAt().getNanos() / 1_000_000L;
        date = TestHelper.timestampToDateTimeString(millis);
        Assertions.assertEquals("2025", date.substring(0, 4));
        Assertions.assertEquals("04", date.substring(5, 7));
        Assertions.assertEquals("14", date.substring(8, 10));
        Assertions.assertEquals("17", date.substring(11, 13));
        Assertions.assertEquals("57", date.substring(14, 16));
        Assertions.assertEquals("jHqH87FH", nbMaxResultsTo.getGameId());

        PerfStatsStreakInfo playStreakTime = playStreak.getTime();
        Assertions.assertNotNull(playStreakTime);
        PerfStatsStreakDetails timeCur = playStreakTime.getCur();
        Assertions.assertNotNull(timeCur);
        Assertions.assertEquals(0, timeCur.getV());
        PerfStatsStreakDetails timeMax = playStreakTime.getMax();
        Assertions.assertNotNull(timeMax);
        TestHelper.testRange(timeMax.getV(), 6700, 7000);
        PerfStatsResults timeMaxResultsFrom = timeMax.getFrom();
        Assertions.assertNotNull(timeMaxResultsFrom);
        millis = timeMaxResultsFrom.getAt().getSeconds() * 1000L + timeMaxResultsFrom.getAt().getNanos() / 1_000_000L;
        date = TestHelper.timestampToDateTimeString(millis);
        Assertions.assertEquals("2025", date.substring(0, 4));
        Assertions.assertEquals("04", date.substring(5, 7));
        Assertions.assertEquals("14", date.substring(8, 10));
        Assertions.assertEquals("14", date.substring(11, 13));
        Assertions.assertEquals("40", date.substring(14, 16));
        Assertions.assertEquals("zxsh2Zo6", timeMaxResultsFrom.getGameId());
        PerfStatsResults timeMaxResultsTo = timeMax.getTo();
        Assertions.assertNotNull(timeMaxResultsTo);
        millis = timeMaxResultsTo.getAt().getSeconds() * 1000L + timeMaxResultsTo.getAt().getNanos() / 1_000_000L;
        date = TestHelper.timestampToDateTimeString(millis);
        Assertions.assertEquals("2025", date.substring(0, 4));
        Assertions.assertEquals("04", date.substring(5, 7));
        Assertions.assertEquals("14", date.substring(8, 10));
        Assertions.assertEquals("17", date.substring(11, 13));
        Assertions.assertEquals("57", date.substring(14, 16));
        Assertions.assertEquals("jHqH87FH", timeMaxResultsTo.getGameId());
        millis = playStreak.getLastDate().getSeconds() * 1000L + playStreak.getLastDate().getNanos() / 1_000_000L;
        date = TestHelper.timestampToDateTimeString(millis);
        Assertions.assertEquals("2026", date.substring(0, 4));
        Assertions.assertEquals("01", date.substring(5, 7));
        Assertions.assertEquals("01", date.substring(8, 10));
        Assertions.assertEquals("13", date.substring(11, 13));
        Assertions.assertEquals("50", date.substring(14, 16));

        PerfStatsResultStreak resultStreak = stats.getResultStreak();
        Assertions.assertNotNull(resultStreak);

        PerfStatsStreakInfo lossStreak = resultStreak.getLoss();
        Assertions.assertNotNull(lossStreak);

        PerfStatsStreakDetails lossCur = lossStreak.getCur();
        Assertions.assertNotNull(lossCur);
        Assertions.assertEquals(0, lossCur.getV());

        PerfStatsStreakDetails lossMax = lossStreak.getMax();
        Assertions.assertNotNull(lossMax);
        Assertions.assertEquals(6, lossMax.getV());

        PerfStatsResults lossMaxResultsFrom = lossMax.getFrom();
        Assertions.assertNotNull(lossMaxResultsFrom);
        millis = lossMaxResultsFrom.getAt().getSeconds() * 1000L + lossMaxResultsFrom.getAt().getNanos() / 1_000_000L;
        date = TestHelper.timestampToDateTimeString(millis);
        Assertions.assertEquals("2025", date.substring(0, 4));
        Assertions.assertEquals("09", date.substring(5, 7));
        Assertions.assertEquals("09", date.substring(8, 10));
        Assertions.assertEquals("21", date.substring(11, 13));
        Assertions.assertEquals("07", date.substring(14, 16));
        Assertions.assertEquals("DSIbTVDd", lossMaxResultsFrom.getGameId());

        PerfStatsResults lossMaxResultsTo = lossMax.getTo();
        Assertions.assertNotNull(lossMaxResultsTo);
        millis = lossMaxResultsTo.getAt().getSeconds() * 1000L + lossMaxResultsTo.getAt().getNanos() / 1_000_000L;
        date = TestHelper.timestampToDateTimeString(millis);
        Assertions.assertEquals("2025", date.substring(0, 4));
        Assertions.assertEquals("09", date.substring(5, 7));
        Assertions.assertEquals("21", date.substring(8, 10));
        Assertions.assertEquals("19", date.substring(11, 13));
        Assertions.assertEquals("09", date.substring(14, 16));
        Assertions.assertEquals("zdFcu3f3", lossMaxResultsTo.getGameId());

        PerfStatsStreakInfo winStreak = resultStreak.getWin();
        Assertions.assertNotNull(winStreak);

        PerfStatsStreakDetails winCur = winStreak.getCur();
        Assertions.assertNotNull(winCur);
        Assertions.assertEquals(1, winCur.getV());

        PerfStatsResults winCurResultsFrom = winCur.getFrom();
        Assertions.assertNotNull(winCurResultsFrom);
        millis = winCurResultsFrom.getAt().getSeconds() * 1000L + winCurResultsFrom.getAt().getNanos() / 1_000_000L;
        date = TestHelper.timestampToDateTimeString(millis);
        Assertions.assertEquals("2026", date.substring(0, 4));
        Assertions.assertEquals("01", date.substring(5, 7));
        Assertions.assertEquals("01", date.substring(8, 10));
        Assertions.assertEquals("13", date.substring(11, 13));
        Assertions.assertEquals("32", date.substring(14, 16));
        Assertions.assertEquals("SJrvot6L", winCurResultsFrom.getGameId());

        PerfStatsResults winCurResultsTo = winCur.getTo();
        Assertions.assertNotNull(winCurResultsTo);
        millis = winCurResultsTo.getAt().getSeconds() * 1000L + winCurResultsTo.getAt().getNanos() / 1_000_000L;
        date = TestHelper.timestampToDateTimeString(millis);
        Assertions.assertEquals("2026", date.substring(0, 4));
        Assertions.assertEquals("01", date.substring(5, 7));
        Assertions.assertEquals("01", date.substring(8, 10));
        Assertions.assertEquals("13", date.substring(11, 13));
        Assertions.assertEquals("50", date.substring(14, 16));
        Assertions.assertEquals("SJrvot6L", winCurResultsTo.getGameId());

        PerfStatsStreakDetails winMax = winStreak.getMax();
        Assertions.assertNotNull(winMax);
        Assertions.assertEquals(9, winMax.getV());

        PerfStatsResults winMaxResultsFrom = winMax.getFrom();
        Assertions.assertNotNull(winMaxResultsFrom);
        millis = winMaxResultsFrom.getAt().getSeconds() * 1000L + winMaxResultsFrom.getAt().getNanos() / 1_000_000L;
        date = TestHelper.timestampToDateTimeString(millis);
        Assertions.assertEquals("2025", date.substring(0, 4));
        Assertions.assertEquals("10", date.substring(5, 7));
        Assertions.assertEquals("19", date.substring(8, 10));
        Assertions.assertEquals("16", date.substring(11, 13));
        Assertions.assertEquals("52", date.substring(14, 16));
        Assertions.assertEquals("tkURk6PY", winMaxResultsFrom.getGameId());

        PerfStatsResults winMaxResultsTo = winMax.getTo();
        Assertions.assertNotNull(winMaxResultsTo);
        millis = winMaxResultsTo.getAt().getSeconds() * 1000L + winMaxResultsTo.getAt().getNanos() / 1_000_000L;
        date = TestHelper.timestampToDateTimeString(millis);
        Assertions.assertEquals("2025", date.substring(0, 4));
        Assertions.assertEquals("11", date.substring(5, 7));
        Assertions.assertEquals("12", date.substring(8, 10));
        Assertions.assertEquals("20", date.substring(11, 13));
        Assertions.assertEquals("31", date.substring(14, 16));
        Assertions.assertEquals("iNV76r9V", winMaxResultsTo.getGameId());

        PerfStatsResults highest = stats.getHighest();
        Assertions.assertNotNull(highest);
        millis = highest.getAt().getSeconds() * 1000L + highest.getAt().getNanos() / 1_000_000L;
        date = TestHelper.timestampToDateTimeString(millis);
        Assertions.assertEquals("2024", date.substring(0, 4));
        Assertions.assertEquals("09", date.substring(5, 7));
        Assertions.assertEquals("19", date.substring(8, 10));
        Assertions.assertEquals("20", date.substring(11, 13));
        Assertions.assertEquals("19", date.substring(14, 16));
        Assertions.assertEquals("kkD3tWUt", highest.getGameId());
        Assertions.assertEquals(1587, highest.getInt());

        PerfStatsResults lowest = stats.getLowest();
        Assertions.assertNotNull(lowest);
        millis = lowest.getAt().getSeconds() * 1000L + lowest.getAt().getNanos() / 1_000_000L;
        date = TestHelper.timestampToDateTimeString(millis);
        Assertions.assertEquals("2020", date.substring(0, 4));
        Assertions.assertEquals("05", date.substring(5, 7));
        Assertions.assertEquals("15", date.substring(8, 10));
        Assertions.assertEquals("06", date.substring(11, 13));
        Assertions.assertEquals("27", date.substring(14, 16));
        Assertions.assertEquals("xgHmGsRG", lowest.getGameId());
        Assertions.assertEquals(1149, lowest.getInt());

    }

}
