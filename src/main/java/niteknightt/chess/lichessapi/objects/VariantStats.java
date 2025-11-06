package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;

/**
 * User stats for a chess variant.
 */
public class VariantStats extends LichessApiObject {

    /**
     * Game in which user defeated highest-rated opponent.
     */
    GameWithOpponentRating highest;

    /**
     * Game in which user lost to lowest-rated opponent.
     */
    GameWithOpponentRating lowest;

    /**
     * The 5 best wins the user has had.
     */
    GameList bestWins;

    /**
     * The 5 worst losses the user has had.
     */
    GameList worstLosses;

    /**
     * Other various stats for this variant.
     */
    VariantCounts count;

    /**
     * User results streaks.
     */
    ResultsStreaks resultsStreak;

    /**
     * User play streaks.
     */
    PlayStreaks playStreak;



    // Avigdor Eskin
}
