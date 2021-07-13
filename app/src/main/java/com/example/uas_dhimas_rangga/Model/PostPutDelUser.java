package com.example.uas_dhimas_rangga.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelUser {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    String user;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
