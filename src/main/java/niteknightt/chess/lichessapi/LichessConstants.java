package niteknightt.chess.lichessapi;

public class LichessConstants {
    public class ChessVariants {
        public static final String ULTRA_BULLET =     "ultraBullet";
        public static final String BULLET =           "bullet";
        public static final String BLITZ =            "blitz";
        public static final String RAPID =            "rapid";
        public static final String CLASSICAL =        "classical";
        public static final String CORRESPONDENCE =   "correspondence";
        public static final String CHESS_960 =        "chess960";
        public static final String KING_OF_THE_HILL = "kingOfTheHill";
        public static final String THREE_CHECK =      "threeCheck";
        public static final String ANTI_CHESS =       "antichess";
        public static final String ATOMIC =           "atomic";
        public static final String HORDE =            "horde";
        public static final String RACING_KINGS =     "racingKings";
        public static final String CRAZY_HOUSE =      "crazyhouse";
        public static final String PUZZLE =           "puzzle";
        public static final String STORM =            "storm";
        public static final String RACER =            "racer";
        public static final String STREAK =           "streak";
    }

    public class CountTypes {
        public static final String ALL = "all";
        public static final String RATED = "rated";
        public static final String DRAW = "draw";
        public static final String LOSS = "loss";
        public static final String WIN = "win";
        public static final String BOOKMARK = "bookmark";
        public static final String PLAYING = "playing";
        public static final String IMPORT = "import";
        public static final String ME = "me";
    }

    // Taken from: https://github.com/lichess-org/api/blob/master/doc/specs/schemas/Timeline.yaml
    public class TimelineEntryTypes {
        public static final String FOLLOW = "follow";
        public static final String TEAM_JOIN = "team-join";
        public static final String TEAM_CREATE = "team-create";
        public static final String FORUM_POST = "forum-post";
        public static final String BLOG_POST = "blog-post";
        public static final String UBLOG_POST = "ublog-post";
        public static final String TOUR_JOIN = "tour-join";
        public static final String GAME_END = "game-end";
        public static final String SIMUL_CREATE = "simul-create";
        public static final String SIMUL_JOIN = "simul-join";
        public static final String STUDY_LIKE = "study-like";
        public static final String PLAN_START = "plan-start";
        public static final String PLAN_RENEW = "plan-renew";
        public static final String UBLOG_POST_LIKE = "ublog-post-like";
        public static final String STREAM_START = "stream-start";
    }

}
