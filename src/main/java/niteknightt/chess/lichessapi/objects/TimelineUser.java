package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessAccountEnums;
import niteknightt.chess.lichessapi.LichessApiObject;

import java.util.List;
import java.util.Map;

/**
 * User in user's timeline.
 */
public class TimelineUser extends LichessApiObject {

    public String id;
    public String name;
    public LichessAccountEnums.Title title;
    public String flair;
    public String patronColor;

}
