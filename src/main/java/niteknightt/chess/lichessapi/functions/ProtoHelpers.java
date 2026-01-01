package niteknightt.chess.lichessapi.functions;

import niteknightt.chess.lichessapi.objects.Account.*;

public class ProtoHelpers {
    enum PrefsTheme {
        NONE,
        blue,
        blue2,
        blue3,
        blue_marble,
        canvas,
        wood,
        wood2,
        wood3,
        wood4,
        maple,
        maple2,
        horsey,
        brown,
        leather,
        green,
        marble,
        green_plastic,
        grey,
        metal,
        olive,
        newspaper,
        purple,
        purple_diag,
        pink,
        ic
    }

    enum PrefsTheme3d {
        NONE,
        Black_White_Aluminium,
        Brushed_Aluminium,
        China_Blue,
        China_Green,
        China_Grey,
        China_Scarlet,
        China_Yellow,
        Classic_Blue,
        Gold_Silver,
        Green_Glass,
        Light_Wood,
        Power_Coated,
        Purple_Black,
        Rosewood,
        Wood_Glass,
        Marble,
        Wax,
        Jade
    }

    public static PrefsTheme apiToPrefsTheme(String val) {
        return switch(val) {
            case "blue" -> PrefsTheme.blue;
            case "blue2" -> PrefsTheme.blue2;
            case "blue3" -> PrefsTheme.blue3;
            case "blue-marble" -> PrefsTheme.blue_marble;
            case "canvas" -> PrefsTheme.canvas;
            case "wood" -> PrefsTheme.wood;
            case "wood2" -> PrefsTheme.wood2;
            case "wood3" -> PrefsTheme.wood3;
            case "wood4" -> PrefsTheme.wood4;
            case "maple" -> PrefsTheme.maple;
            case "maple2" -> PrefsTheme.maple2;
            case "horsey" -> PrefsTheme.horsey;
            case "brown" -> PrefsTheme.brown;
            case "leather" -> PrefsTheme.leather;
            case "green" -> PrefsTheme.green;
            case "marble" -> PrefsTheme.marble;
            case "green-plastic" -> PrefsTheme.green_plastic;
            case "grey" -> PrefsTheme.grey;
            case "metal" -> PrefsTheme.metal;
            case "olive" -> PrefsTheme.olive;
            case "newspaper" -> PrefsTheme.newspaper;
            case "purple" -> PrefsTheme.purple;
            case "purple-diag" -> PrefsTheme.purple_diag;
            case "pink" -> PrefsTheme.pink;
            case "ic" -> PrefsTheme.ic;
            default -> PrefsTheme.NONE;
        };
    }

    public static String prefsThemeToApi(PrefsTheme val) {
        return switch(val) {
            case blue -> "blue";
            case blue2 -> "blue2";
            case blue3 -> "blue3";
            case blue_marble -> "blue-marble";
            case canvas -> "canvas";
            case wood -> "wood";
            case wood2 -> "wood2";
            case wood3 -> "wood3";
            case wood4 -> "wood4";
            case maple -> "maple";
            case maple2 -> "maple2";
            case horsey -> "horsey";
            case brown -> "brown";
            case leather -> "leather";
            case green -> "green";
            case marble -> "marble";
            case green_plastic -> "green-plastic";
            case grey -> "grey";
            case metal -> "metal";
            case olive -> "olive";
            case newspaper -> "newspaper";
            case purple -> "purple";
            case purple_diag -> "purple-diag";
            case pink -> "pink";
            case ic -> "ic";
            default -> "";
        };
    }

    public static PrefsTheme3d apiToPrefsTheme3d(String val) {
        return switch(val) {
            case "Black-White-Aluminium" -> PrefsTheme3d.Black_White_Aluminium;
            case "Brushed-Aluminium" -> PrefsTheme3d.Brushed_Aluminium;
            case "China-Blue" -> PrefsTheme3d.China_Blue;
            case "China-Green" -> PrefsTheme3d.China_Green;
            case "China-Grey" -> PrefsTheme3d.China_Grey;
            case "China-Scarlet" -> PrefsTheme3d.China_Scarlet;
            case "China-Yellow" -> PrefsTheme3d.China_Yellow;
            case "Classic-Blue" -> PrefsTheme3d.Classic_Blue;
            case "Gold-Silver" -> PrefsTheme3d.Gold_Silver;
            case "Green-Glass" -> PrefsTheme3d.Green_Glass;
            case "Light-Wood" -> PrefsTheme3d.Light_Wood;
            case "Power-Coated" -> PrefsTheme3d.Power_Coated;
            case "Purple-Black" -> PrefsTheme3d.Purple_Black;
            case "Rosewood" -> PrefsTheme3d.Rosewood;
            case "Wood-Glass" -> PrefsTheme3d.Wood_Glass;
            case "Marble" -> PrefsTheme3d.Marble;
            case "Wax" -> PrefsTheme3d.Wax;
            case "Jade" -> PrefsTheme3d.Jade;
            default -> PrefsTheme3d.NONE;
        };
    }

    public static String prefsThemeToApi(PrefsTheme3d val) {
        return switch(val) {
            case Black_White_Aluminium -> "Black-White-Aluminium";
            case Brushed_Aluminium -> "Brushed-Aluminium";
            case China_Blue -> "China-Blue";
            case China_Green -> "China-Green";
            case China_Grey -> "China-Grey";
            case China_Scarlet -> "China-Scarlet";
            case China_Yellow -> "China-Yellow";
            case Classic_Blue -> "Classic-Blue";
            case Gold_Silver -> "Gold-Silver";
            case Green_Glass -> "Green-Glass";
            case Light_Wood -> "Light-Wood";
            case Power_Coated -> "Power-Coated";
            case Purple_Black -> "Purple-Black";
            case Rosewood -> "Rosewood";
            case Wood_Glass -> "Wood-Glass";
            case Marble -> "Marble";
            case Wax -> "Wax";
            case Jade -> "Jade";
            default -> "";
        };
    }
}
