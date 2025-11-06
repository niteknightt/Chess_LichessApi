package niteknightt.chess.lichessapi.objects;

import java.util.List;

/**
 * Details of a game exported from Lichess.
 */
public class ExportedGame {
    public String id;
    public boolean rated;
    public String variant;
    public String speed;
    public long createdAt;
    public long lastMoveAt;
    public String status;
    public String source;
    public Players players;
    public String fullId;
    public String winner;
    public String moves;
}
