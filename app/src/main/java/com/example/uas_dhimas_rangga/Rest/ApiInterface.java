package com.example.uas_dhimas_rangga.Rest;

import com.example.uas_dhimas_rangga.Model.GetUser;
import com.example.uas_dhimas_rangga.Model.PostPutDelUser;
import com.example.uas_dhimas_rangga.Model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("users")
    Call<GetUser> getuser();
    @FormUrlEncoded
    @POST("users")
    Call<PostPutDelUser>postUser(String s, @Field("name") String name,
                                 @Field("job") String job);

    @FormUrlEncoded
    @POST("users")
    Call<PostPutDelUser>puttUser(@Field("name") String name,
                                 @Field("job") String job);

    @FormUrlEncoded
    @HTTP(method = "Hapus", path = "users", hasBody = true)
    Call<PostPutDelUser>hapusUsers(@Field("name") String id);
}
