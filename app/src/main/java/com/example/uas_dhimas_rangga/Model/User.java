package com.example.uas_dhimas_rangga.Model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private String id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("email")
    private String email;
    @SerializedName("telepon")
    private String telepon;
    public User() {}
    public User(String id, String nama, String email, String telepon){
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;

    }

    public void setId(String id){
        this.id = id;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelepon(String telepon){
        this.telepon = telepon;
    }

    public String getNama(){
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getTelepon() {
        return telepon;
    }
}
