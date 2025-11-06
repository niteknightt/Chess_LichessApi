package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessAccountEnums;
import niteknightt.chess.lichessapi.LichessApiObject;

/**
 * Entry in user's timeline.
 */
public class TimelineEntry extends LichessApiObject {

    /**
     * Type of activity. TODO: Change type from string to enum.
     */
    public LichessAccountEnums.TimelineEntryType type;

    /**
     * Timestamp of activity. TODO: See if we can change the type to something else.
     */
    public long date;

    /**
     * Additional information about activity.
     */
    public TimelineEntryData data;
}
