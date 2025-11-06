package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;

/**
 * Various user numbers for a chess variant.
 */
public class VariantCounts extends LichessApiObject {

    /**
     * Number of games played.
     */
    int all;

    /**
     * Number of rated games played.
     */
    int rated;

    /**
     * Number of games won.
     */
    int win;

    /**
     * Number of games lost.
     */
    int loss;

    /**
     * Number of games drawn.
     */
    int draw;

    /**
     * TODO: What is this?
     */
    int tour;

    /**
     * Number of times user berserked. TODO: Verify.
     */
    int berserk;

    /**
     * Average opponent rating.
     */
    float opAvg;

    /**
     * Number of seconds played.
     */
    int seconds;

    /**
     * Number of disconnects.
     */
    int disconnects;
}
