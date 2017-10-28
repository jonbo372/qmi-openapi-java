package tw.com.mitake.response;

import com.google.gson.annotations.SerializedName;

public class AbstractResponse {
    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }
}
