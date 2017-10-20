package by.brstu.dmitry.vkfriends.pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HelloWorldClass {

    @SerializedName("response")
    @Expose
    private String response;

    @SerializedName("error")
    @Expose
    private Error error;

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}