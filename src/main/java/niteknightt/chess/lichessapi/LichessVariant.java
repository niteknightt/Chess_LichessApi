package niteknightt.chess.lichessapi;

import com.google.gson.annotations.SerializedName;

public class LichessVariant extends LichessApiObject {
    public LichessEnums.VariantKey key;
    public String name;
    @SerializedName("short")
    public String shortName;
}
