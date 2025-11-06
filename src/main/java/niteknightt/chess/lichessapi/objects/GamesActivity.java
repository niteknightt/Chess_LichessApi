package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;
import niteknightt.chess.lichessapi.LichessUsersEnums;

import java.util.List;
import java.util.Map;

/**
 * Activity of a user.
 */
public class GamesActivity extends LichessApiObject {

    /**
     * The interval of time that these activities occurred in.
     */
    Interval interval;

    Map<LichessUsersEnums.ActivityVariant, VariantActivity> games;

    PuzzleActivity puzzles;

    RunsAndScore storm;

    RunsAndScore racer;

    RunsAndScore streak;

    TournamentActivity tournaments;

    List<Practice> practice;

    List<String> simuls;



}
