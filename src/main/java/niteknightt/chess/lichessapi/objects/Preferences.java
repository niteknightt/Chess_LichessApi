package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessAccountEnums;

/**
 * User preferences.
 */
public class Preferences {
    /**
     * Does user use dark mode.
     */
    public boolean dark;

    /**
     * Does user use transparent mode.
     */
    public boolean transp;

    /**
     * Background image.
     */
    public String bgImg;

    /**
     * Does user use 3D view.
     */
    public boolean is3d;

    /**
     * Theme the user has set for the site.
     */
    public LichessAccountEnums.Theme theme;

    /**
     * Piece set the user has set.
     */
    public LichessAccountEnums.PieceSet pieceSet;

    /**
     * 3D theme the user has set for the site.
     */
    public LichessAccountEnums.Theme3D theme3d;

    /**
     * 3D piece set the user has set.
     */
    public LichessAccountEnums.PieceSet3D pieceSet3d;

    /**
     * Sound set the user has set.
     */
    public LichessAccountEnums.SoundSet soundSet;

    /**
     * TODO: Figure out what this is.
     */
    public int blindfold;

    /**
     * Should pawn promote to queen automatically.
     * TODO: Figure out why this is an int.
     */
    public int autoQueen;

    /**
     * Should threefold repetition cause an automatic draw.
     * TODO: Figure out why this is an int.
     */
    public int autoThreefold;

    /**
     * Are takebacks allowed.
     * TODO: Figure out why this is an int.
     */
    public int takeback;

    /**
     * TODO: Figure out what this is.
     */
    public int moretime;

    /**
     * TODO: Figure out what this is.
     */
    public int clockTenths;

    /**
     * TODO: Figure out what this is.
     */
    public boolean clockBar;

    /**
     * TODO: Figure out what this is.
     */
    public boolean clockSound;

    /**
     * Are premoves enabled.
     */
    public boolean premove;

    /**
     * TODO: Figure out what this is.
     */
    public int animation;

    /**
     * TODO: Figure out what this is.
     */
    public int pieceNotation;

    /**
     * TODO: Figure out what this is.
     */
    public boolean captured;

    /**
     * TODO: Figure out what this is.
     */
    public boolean follow;

    /**
     * TODO: Figure out what this is.
     */
    public boolean highlight;

    /**
     * TODO: Figure out what this is.
     */
    public boolean destination;

    /**
     * TODO: Figure out what this is.
     */
    public int coords;

    /**
     * TODO: Figure out what this is.
     */
    public int replay;

    /**
     * TODO: Figure out what this is.
     */
    public int challenge;

    /**
     * TODO: Figure out what this is.
     */
    public int message;

    /**
     * TODO: Figure out what this is.
     */
    public int submitMove;

    /**
     * Should UI request that user confirm resignation.
     * TODO: Figure out why this is an int.
     */
    public int confirmResign;

    /**
     * TODO: Figure out what this is.
     */
    public int insightsShare;

    /**
     * TODO: Figure out what this is.
     */
    public int keyboardMove;

    /**
     * TODO: Figure out what this is.
     */
    public boolean voiceMove;

    /**
     * Should user play in zen mode.
     * TODO: Figure out why this is an int.
     */
    public int zen;

    /**
     * TODO: Figure out what this is.
     */
    public int ratings;

    /**
     * TODO: Figure out what this is.
     */
    public int moveEvent;

    /**
     * TODO: Figure out what this is.
     */
    public int rookCastle;

    /**
     * TODO: Figure out what this is.
     */
    public boolean flairs;

    /**
     * Should automatically message "GG" after a game.
     * 0 = No, 1 = When losing, 2 = When losing or drawing
     */
    public int sayGG;




}
