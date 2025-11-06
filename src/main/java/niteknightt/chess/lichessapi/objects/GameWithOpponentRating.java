package niteknightt.chess.lichessapi.objects;

import com.google.gson.annotations.SerializedName;

/**
 * Info about a game including opponent rating.
 */
public class GameWithOpponentRating {

    /**
     * Opponent rating.
     */
    @SerializedName("int")
    public int opponentRating;

    /**
     * When the game started in YYYY-MM-DDTHH:MM:SS.000Z format.
     */
    public String at;

    /**
     * ID of the game.
     */
    public String gameId;
}
