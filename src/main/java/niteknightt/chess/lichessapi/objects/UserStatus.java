package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessAccountEnums;
import niteknightt.chess.lichessapi.LichessApiObject;

import java.util.List;
import java.util.Map;

/**
 * Real-time user status without current game info except for ID.
 */
public class UserStatus extends LichessApiObject {

    /**
     * User ID.
     */
    public String id;

    /**
     * User name.
     */
    public String name;

    /**
     * User flair.
     */
    public String flair;

    /**
     * User title.
     */
    public LichessAccountEnums.Title title;

    /**
     * Is user online.
     */
    public boolean online;

    /**
     * Is user currently playing.
     */
    public boolean playing;

    /**
     * Is user currently streaming.
     */
    public boolean streaming;

    /**
     * User's wing color
     */
    public int patronColor;

    /**
     * Quality of user's connection (1 = poor, 2, 3, 4 = great).
     * Only in response if called with "withSignal=true".
     */
    public int signal;

    /**
     * Game ID that the user is currently playing.
     * Only in response if called with "withGameIds=true"
     */
    public String playingId;
    /*
ttt [{"name":"Katauri","id":"katauri","online":true,"playing":true,"signal":3,"playingId":"lsYqQ76f"}]
ttf [{"name":"Katauri","id":"katauri","online":true,"playing":true,"signal":3,"playingId":"lsYqQ76f"}]
tft [{"name":"Katauri","id":"katauri","online":true,"playing":{"id":"lsYqQ76f","clock":"10+5"},"signal":3}]
tff [{"name":"Katauri","id":"katauri","online":true,"playing":true,"signal":3}]
ftt [{"name":"Katauri","id":"katauri","online":true,"playing":true,"playingId":"lsYqQ76f"}]
ftf [{"name":"Katauri","id":"katauri","online":true,"playing":true,"playingId":"lsYqQ76f"}]
fft [{"name":"Katauri","id":"katauri","online":true,"playing":{"id":"lsYqQ76f","clock":"10+5"}}]
fff [{"name":"Katauri","id":"katauri","online":true,"playing":true}]


     */
}
