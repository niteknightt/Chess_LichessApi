package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;

/**
 * User preferences and language setting.
 */
public class PrefsAndLang extends LichessApiObject {
    /**
     * User preferences.
     */
    public Preferences prefs;

    /**
     * User language, as IETF language tag, e.g. en-US.
     */
    public String language;
}
