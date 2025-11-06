package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessAccountEnums;
import niteknightt.chess.lichessapi.LichessApiObject;

/**
 * An interval of time.
 */
public class Interval extends LichessApiObject {

    /**
     * Start of the interval, as a timestamp in seconds.
     */
    long start;

    /**
     * End of the interval, as a timestamp in seconds.
     */
    long end;
}
