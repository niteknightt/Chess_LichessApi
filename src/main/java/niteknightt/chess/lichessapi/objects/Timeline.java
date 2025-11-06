package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;

import java.util.List;
import java.util.Map;

/**
 * Recent user activity.
 */
public class Timeline extends LichessApiObject {

    /**
     * Activities. TODO: Figure out what this is.
     */
    public List<TimelineEntry> entries;

    /**
     * Users. TODO: Figure out what this is.
     */
    public Map<String, TimelineUser> users;
}
