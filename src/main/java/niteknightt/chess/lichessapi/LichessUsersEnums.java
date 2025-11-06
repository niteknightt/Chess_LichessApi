package niteknightt.chess.lichessapi;

import com.google.gson.annotations.SerializedName;

public class LichessUsersEnums {

    public enum VariantKey {
        @SerializedName("bullet")
        BULLET,
        @SerializedName("blitz")
        BLITZ,
        @SerializedName("rapid")
        RAPID,
        @SerializedName("classical")
        CLASSICAL,
        @SerializedName("ultraBullet")
        ULTRA_BULLET,
        @SerializedName("crazyhouse")
        CRAZY_HOUSE,
        @SerializedName("chess960")
        CHESS_960,
        @SerializedName("kingOfTheHill")
        KING_OF_THE_HILL,
        @SerializedName("threeCheck")
        THREE_CHECK,
        @SerializedName("antichess")
        ANTICHESS,
        @SerializedName("atomic")
        ATOMIC,
        @SerializedName("horde")
        HORDE,
        @SerializedName("racingKings")
        RACING_KINGS
    }

    public static String variantKeyText(VariantKey chessVariant) {
        switch (chessVariant) {
            case BULLET:
                return "bullet";
            case BLITZ:
                return "blitz";
            case RAPID:
                return "rapid";
            case CLASSICAL:
                return "classical";
            case ULTRA_BULLET:
                return "ultraBullet";
            case CRAZY_HOUSE:
                return "crazyHouse";
            case CHESS_960:
                return "chess960";
            case KING_OF_THE_HILL:
                return "kingOfTheHill";
            case THREE_CHECK:
                return "threeCheck";
            case ANTICHESS:
                return "antichess";
            case ATOMIC:
                return "atomic";
            case HORDE:
                return "horde";
            case RACING_KINGS:
                return "racingKings";
            default:
                throw new RuntimeException("Unknown variant: " + chessVariant);
        }
    }

    public enum VariantName {
        @SerializedName("UltraBullet")
        ULTRA_BULLET,
        @SerializedName("Bullet")
        BULLET,
        @SerializedName("Blitz")
        BLITZ,
        @SerializedName("Rapid")
        RAPID,
        @SerializedName("Classical")
        CLASSICAL,
        @SerializedName("Correspondence")
        CORRESPONDENCE,
        @SerializedName("Crazyhouse")
        CRAZY_HOUSE,
        @SerializedName("Chess960")
        CHESS_960,
        @SerializedName("King of the Hill")
        KING_OF_THE_HILL,
        @SerializedName("Three-check")
        THREE_CHECK,
        @SerializedName("Antichess")
        ANTICHESS,
        @SerializedName("Atomic")
        ATOMIC,
        @SerializedName("Horde")
        HORDE,
        @SerializedName("Racing Kings")
        RACING_KINGS,
        @SerializedName("Puzzles")
        PUZZLES
    }

    public enum PerfVariant {
        @SerializedName("ultraBullet")
        ULTRA_BULLET,
        @SerializedName("bullet")
        BULLET,
        @SerializedName("blitz")
        BLITZ,
        @SerializedName("rapid")
        RAPID,
        @SerializedName("classical")
        CLASSICAL,
        @SerializedName("correspondence")
        CORRESPONDENCE,
        @SerializedName("chess960")
        CHESS_960,
        @SerializedName("crazyhouse")
        CRAZY_HOUSE,
        @SerializedName("antichess")
        ANTICHESS,
        @SerializedName("atomic")
        ATOMIC,
        @SerializedName("horde")
        HORDE,
        @SerializedName("kingOfTheHill")
        KING_OF_THE_HILL,
        @SerializedName("racingKings")
        RACING_KINGS,
        @SerializedName("threeCheck")
        THREE_CHECK
    }

    public static String perfVariantText(PerfVariant chessVariant) {
        switch (chessVariant) {
            case ULTRA_BULLET:
                return "ultraBullet";
            case BULLET:
                return "bullet";
            case BLITZ:
                return "blitz";
            case RAPID:
                return "rapid";
            case CLASSICAL:
                return "classical";
            case CORRESPONDENCE:
                return "correspondence";
            case CHESS_960:
                return "chess960";
            case CRAZY_HOUSE:
                return "crazyHouse";
            case ANTICHESS:
                return "antichess";
            case ATOMIC:
                return "atomic";
            case HORDE:
                return "horde";
            case KING_OF_THE_HILL:
                return "kingOfTheHill";
            case RACING_KINGS:
                return "racingKings";
            case THREE_CHECK:
                return "threeCheck";
            default:
                throw new RuntimeException("Unknown perf variant: " + chessVariant);
        }
    }

    public enum ActivityVariant {
        @SerializedName("chess960")
        CHESS_960,
        @SerializedName("atomic")
        ATOMIC,
        @SerializedName("racingKings")
        RACING_KINGS,
        @SerializedName("ultraBullet")
        ULTRA_BULLET,
        @SerializedName("blitz")
        BLITZ,
        @SerializedName("kingOfTheHill")
        KING_OF_THE_HILL,
        @SerializedName("bullet")
        BULLET,
        @SerializedName("correspondence")
        CORRESPONDENCE,
        @SerializedName("horde")
        HORDE,
        @SerializedName("puzzle")
        PUZZLE,
        @SerializedName("classical")
        CLASSICAL,
        @SerializedName("rapid")
        RAPID
    }

}
