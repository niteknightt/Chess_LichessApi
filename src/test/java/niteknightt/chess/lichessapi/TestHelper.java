package niteknightt.chess.lichessapi;

import niteknightt.chess.lichessapi.objects.Account.*;
import org.junit.jupiter.api.Assertions;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class TestHelper {
    /////////////////////////////////////////////////
    // Helper functions to test GetMyProfileResponse
    /////////////////////////////////////////////////

    public static void testVariantActivity(GetMyProfilePerfType1 variantPerfs,
                                    int gamesMin, int gamesMax,
                                    int progMin, int progMax,
                                    int ratingMin, int ratingMax,
                                    int rdMin, int rdMax,
                                    boolean provisional) {
        if (gamesMin != gamesMax) {
            Assertions.assertTrue(variantPerfs.getGames() >= gamesMin && variantPerfs.getGames() <= gamesMax);
        }
        else {
            Assertions.assertEquals(0, variantPerfs.getGames());
        }
        if (progMin != progMax) {
            Assertions.assertTrue(variantPerfs.getProg() >= progMin && variantPerfs.getProg() <= progMax);
        }
        else {
            Assertions.assertEquals(0, variantPerfs.getProg());
        }
        if (ratingMin != ratingMax) {
            Assertions.assertTrue(variantPerfs.getRating() >= ratingMin && variantPerfs.getRating() <= ratingMax);
        }
        else {
            Assertions.assertEquals(0, variantPerfs.getRating());
        }
        if (rdMin != rdMax) {
            Assertions.assertTrue(variantPerfs.getRd() >= rdMin && variantPerfs.getRd() <= rdMax);
        }
        else {
            Assertions.assertEquals(0, variantPerfs.getRd());
        }
        Assertions.assertEquals(provisional, variantPerfs.getProv());
    }

    public static void testVariantRank(GetMyProfilePerfType1 variantPerfs,
                                           int rankMin, int rankMax) {
        if (rankMin != rankMax) {
            Assertions.assertTrue(variantPerfs.getRank() >= rankMin && variantPerfs.getRank() <= rankMax);
        }
        else {
            Assertions.assertEquals(0, variantPerfs.getRank());
        }
    }

    public static void testNoActivityForVariant(GetMyProfilePerfType1 variantPerfs) {
        Assertions.assertEquals(0, variantPerfs.getGames());
        Assertions.assertEquals(0, variantPerfs.getProg());
        Assertions.assertEquals(0, variantPerfs.getRating());
        Assertions.assertEquals(0, variantPerfs.getRd());
        Assertions.assertEquals(false, variantPerfs.getProv());
        Assertions.assertEquals(0, variantPerfs.getRank());
    }

    public static void testNoActivityForVariant(GetMyProfilePerfType2 variantPerfs) {
        Assertions.assertEquals(0, variantPerfs.getRuns());
        Assertions.assertEquals(0, variantPerfs.getScore());
    }

    public static void testNoStreaming(GetMyProfileStreamer streamerInfo) {
        Assertions.assertNotNull(streamerInfo.getTwitch());
        Assertions.assertEquals("", streamerInfo.getTwitch().getChannel());
        Assertions.assertNotNull(streamerInfo.getYouTube());
        Assertions.assertEquals("", streamerInfo.getYouTube().getChannel());
    }

    public static void testStreaming(GetMyProfileStreamer streamerInfo, String twitch, String youtube) {
        Assertions.assertNotNull(streamerInfo.getTwitch());
        Assertions.assertEquals(twitch, streamerInfo.getTwitch().getChannel());
        Assertions.assertNotNull(streamerInfo.getYouTube());
        Assertions.assertEquals(youtube, streamerInfo.getYouTube().getChannel());
    }

    /////////////////////////////////////////////////
    // General helper functions for tests
    /////////////////////////////////////////////////

    public static String timestampToDateString(long timestampMillis) {
        Instant instant = Instant.ofEpochMilli(timestampMillis);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneOffset.UTC);
        return formatter.format(instant);
    }

    public static String timestampToDateTimeString(long timestampMillis) {
        Instant instant = Instant.ofEpochMilli(timestampMillis);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.000").withZone(ZoneOffset.UTC);
        return formatter.format(instant);
    }

    public static void testDate(long timestampMillis, String expectedResult) {
        Assertions.assertEquals(expectedResult, timestampToDateString(timestampMillis));
    }

    public static void testRange(float val, float min, float max) {
        Assertions.assertTrue(val >= min && val <= max);
    }

    public static void testRange(int val, int min, int max) {
        Assertions.assertTrue(val >= min && val <= max);
    }

}
