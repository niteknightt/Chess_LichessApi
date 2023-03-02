package niteknightt.chess.lichessapi;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LichessAllChallenges extends LichessApiObject {
    @SerializedName("in")
    public List<LichessChallenge> incomingChallenges;

    @SerializedName("out")
    public List<LichessChallenge> outgoingChallenges;
}
