package com.example.quchwe.qqspacedemo.data.Module;

import android.content.Context;

import com.example.quchwe.qqspacedemo.data.source.local;
import com.example.quchwe.qqspacedemo.data.source.remoteSource;
import com.example.quchwe.qqspacedemo.data.source.localSource.LocalDataSource;
import com.example.quchwe.qqspacedemo.data.source.remote.RemoteDataSource;
import com.example.quchwe.qqspacedemo.util.schedulers.BaseSchedulerProvider;
import com.example.quchwe.qqspacedemo.util.schedulers.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by quchwe on 2016/9/7 0007.
 */

@Module
public class DataResiposityMoudle {

//    final SchedulerProvider provider;
//    public DataResiposityMoudle(SchedulerProvider provider){
//        this.provider = provider;
//    }

    @Singleton
    @Provides
    @local
    LocalDataSource provideLocalDataSource(Context context,SchedulerProvider provider) {
        return new LocalDataSource(context,provider);
    }

    @Singleton
    @Provides
    @remoteSource
    RemoteDataSource provideRemoteDataSource(SchedulerProvider provider){
        return new RemoteDataSource(provider);
    }
}
