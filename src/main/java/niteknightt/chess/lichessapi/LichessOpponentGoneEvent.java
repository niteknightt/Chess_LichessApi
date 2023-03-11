package niteknightt.chess.lichessapi;

import com.google.gson.annotations.SerializedName;

public class LichessOpponentGoneEvent extends LichessGameEvent {
    @SerializedName("type")
    public LichessEnums.GameStateType gameStateType;
    public boolean gone;
    public int claimWinInSeconds;
}
