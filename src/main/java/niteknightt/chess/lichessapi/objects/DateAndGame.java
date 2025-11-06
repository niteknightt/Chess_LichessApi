package niteknightt.chess.lichessapi.objects;

/**
 * A game and the day it was played.
 */
public class DateAndGame {
    /**
     * Time the game was played, in format YYYY-MM-DDTHH:MM:SS.000Z.
     */
    public String at;

    /**
     * ID of the game.
     */
    public String gameId;
}
