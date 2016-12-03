package com.example.quchwe.qqspacedemo.data.source.remote;

import android.os.Environment;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.quchwe.qqspacedemo.AppAplication;
import com.example.quchwe.qqspacedemo.data.Entity.Things;
import com.example.quchwe.qqspacedemo.data.Entity.User;
import com.example.quchwe.qqspacedemo.data.source.DataSource;

import com.example.quchwe.qqspacedemo.data.source.remote.Api.ConnectService;
import com.example.quchwe.qqspacedemo.util.schedulers.SchedulerProvider;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by quchwe on 2016/9/3 0003.
 */

@Singleton
public class RemoteDataSource implements DataSource {


    @Inject
    ConnectService service;
    Gson gson;

     SchedulerProvider schedulerProvider;


    public RemoteDataSource(SchedulerProvider provider){
        AppAplication.getComponent().inject(this);
        this.schedulerProvider = provider;
        gson = new Gson();
    }
    @Override
    public Observable<List<Things>> getThingss(int userId,int mode,long time) {
        Log.d("静儿","wqvb");
        return service.getAllThings(userId,mode,time).subscribeOn(schedulerProvider.io()).flatMap(new Func1<ResponseBody, Observable<List<Things>>>() {
            @Override
            public Observable<List<Things>> call(ResponseBody responseBody) {
                try {
                    List<Things> thingses = gson.fromJson(responseBody.string(),new TypeToken<List<Things>>(){}.getType());
                    return Observable.just(thingses);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

    }

    @Override
    public Observable<Things> getThings(@NonNull String userId,String thingsId) {
       return null;
    }

    @Override
    public void saveThings(@NonNull Things Things) {

    }

    @Override
    public void saveUsers(@NonNull User user) {

    }

    @Override
    public Observable<List<User>> getUsers() {
        return null;
    }

    @Override
    public Observable<User> getUser(@NonNull String userId,String password) {
        Log.d(userId,password+"rempte");
        if (userId!=null&&password!=null){
            Log.d(userId,password+"rempte");
         return service.login(userId,password).subscribeOn(schedulerProvider.io())
            .flatMap(new Func1<ResponseBody, Observable<User>>() {
                @Override
                public Observable<User> call(ResponseBody responseBody) {
                    try {
                        String s = responseBody.string();
                       User user =  gson.fromJson(s,User.class);
                        Log.d("静儿",user.getUserName());
                        return Observable.just(user);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            });
        }else if (userId!=null&&password==null){
            return service.getUser(Integer.valueOf(userId)).subscribeOn(schedulerProvider.io())
                    .flatMap(new Func1<ResponseBody, Observable<User>>() {
                        @Override
                        public Observable<User> call(ResponseBody responseBody) {
                            try {
                                String s = responseBody.string();
                                User user = gson.fromJson(s,User.class);

                                return Observable.just(user);
                            } catch (IOException e) {
                                e.printStackTrace();
                                return null;
                            }

                        }
                    });

        }
        return null;
    }

    @Override
    public void completeThings(@NonNull Things Things) {

    }

    @Override
    public void clearCompletedThingss() {

    }

    @Override
    public void refreshThingss() {

    }

    @Override
    public void deleteThings(@NonNull int thingsId) {

    }

    public Observable<String> signUp(String userName,String password,String headImage){
        System.out.println(headImage);
        File file = new File(Environment.getExternalStorageDirectory(),"headImage.png");
        System.out.println(file.exists());
        RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/jpg"), file);
        MultipartBody.Part photo = MultipartBody.Part.createFormData("headImage", "headImage.png", photoRequestBody);
        return service.signUp(photo,RequestBody.create(null,userName),RequestBody.create(null,password)).subscribeOn(schedulerProvider.io())
                .flatMap(new Func1<ResponseBody, Observable<String>>() {
                    @Override
                    public Observable<String> call(ResponseBody response) {
                        try {
                            return Observable.just(response.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                });
    }
}
