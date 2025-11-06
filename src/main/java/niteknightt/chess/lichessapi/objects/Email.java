package niteknightt.chess.lichessapi.objects;

import com.google.gson.annotations.SerializedName;
import niteknightt.chess.lichessapi.LichessApiObject;

import java.util.Map;

/**
 * Email address of an account.
 */
public class Email extends LichessApiObject {

    /**
     * The email address of the account owner.
     */
    public String email;

}
