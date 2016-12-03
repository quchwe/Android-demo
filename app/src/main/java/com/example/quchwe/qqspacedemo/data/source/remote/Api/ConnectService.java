package com.example.quchwe.qqspacedemo.data.source.remote.Api;



import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * Created by quchwe on 2016/9/5 0005.
 */

public interface ConnectService {

        @POST("/")
        @FormUrlEncoded
        Observable<ResponseBody> getUser(@Field("userId") int UserId);



        @POST("/qqLogin")
        @FormUrlEncoded
        Observable<ResponseBody> login(@Field("userId") String userId, @Field("password") String password);


        @POST("/getAllThings")
        @FormUrlEncoded
        Observable<ResponseBody> getAllThings(@Field("userId") int userId, @Field("mode") int mode, @Field("publishDate") long time);

        @GET("/getAllThings")
        Observable<ResponseBody> getAllThings();
        @POST("/getMyThings")
        @FormUrlEncoded
        Observable<ResponseBody> getMyThings(@Field("userId") int userId, @Field("publishDate") long time);

        @POST("/getLoginHead")
        Observable<ResponseBody> getLoginHeadImage(@Field("userId") int userId);

        @Multipart
        @POST("/qqSignUp")
        Observable<ResponseBody> signUp(@Part  MultipartBody.Part photo, @Part("username") RequestBody username, @Part("password") RequestBody password);

       @Multipart
        @POST("/file")
        Observable<ResponseBody> up(@Part MultipartBody.Part photo,@Part("name") RequestBody userName);

}
