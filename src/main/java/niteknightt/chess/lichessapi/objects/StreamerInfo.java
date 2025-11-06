package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;

/**
 * Information about user that streams.
 */
public class StreamerInfo extends LichessApiObject {

    /**
     * The twitch channel that the user streams on.
     */
    public TwitchInfo twitch;

    /**
     * The twitch channel that the user streams on.
     */
    public YouTubeInfo youTube;
}
