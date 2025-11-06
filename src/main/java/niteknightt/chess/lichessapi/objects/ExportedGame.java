package niteknightt.chess.lichessapi.objects;

import java.util.List;

/**
 * Details of a game exported from Lichess.
 */
public class ExportedGame {
    String id;
    boolean rated;
    String variant;
    String speed;
    long createdAt;
    long lastMoveAt;
    String status;
    String source;
    Players players;
    String fullId;
    String winner;
    String moves;
}
