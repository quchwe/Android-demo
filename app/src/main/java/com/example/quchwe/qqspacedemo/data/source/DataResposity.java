package com.example.quchwe.qqspacedemo.data.source;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.quchwe.qqspacedemo.data.Entity.Things;
import com.example.quchwe.qqspacedemo.data.Entity.User;
import com.example.quchwe.qqspacedemo.data.source.localSource.LocalDataSource;
import com.example.quchwe.qqspacedemo.data.source.remote.RemoteDataSource;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by quchwe on 2016/9/6 0006.
 */

public class DataResposity implements DataSource {



    private final LocalDataSource mLocalDataSource;
    private final RemoteDataSource mRemoteDataSource;

    @Inject
    DataResposity(@local LocalDataSource localDataSource,@remoteSource RemoteDataSource remoteDataSource){
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<Things>> getThingss(int userId, int mode, long time) {
        return mRemoteDataSource.getThingss(userId,mode,time);
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
            mLocalDataSource.saveUsers(user);
    }

    @Override
    public Observable<List<User>> getUsers() {
        return null;
    }

    @Override
    public Observable<User> getUser(String userId,String pa) {
       Observable<User> userObservable =  mLocalDataSource.getUser(userId,pa);
        if (userObservable==null){
            return mRemoteDataSource.getUser(userId,pa);
        }
        else return userObservable;
//        return mRemoteDataSource.getUser(userId,pa);
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

    public Observable<String> signUp(String userName,String password,@Nullable String headImage){
        return mRemoteDataSource.signUp(userName,password,headImage);
    }
}
