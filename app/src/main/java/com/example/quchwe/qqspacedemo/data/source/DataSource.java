package com.example.quchwe.qqspacedemo.data.source;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.quchwe.qqspacedemo.data.Entity.Things;
import com.example.quchwe.qqspacedemo.data.Entity.User;

import java.util.List;

import rx.Observable;

/**
 * Created by quchwe on 2016/9/1 0001.
 */

public interface DataSource {
    public static final int MODE_PRIVATE = 0;
    public static final int MODE_ALL = 1;

    Observable<List<Things>> getThingss(int userId,int mode,long time);

    Observable<Things> getThings(@NonNull String userId,@NonNull String thingsId);

    void saveThings(@NonNull Things Things);
    void saveUsers(@NonNull User user);

    Observable<List<User>> getUsers();
    Observable<User> getUser(String userId ,@Nullable String pass);


    void completeThings(@NonNull Things Things);

    void clearCompletedThingss();

    void refreshThingss();



    void deleteThings(@NonNull int thingsId);
}
