package com.example.quchwe.qqspacedemo.data.Componet;

import com.example.quchwe.qqspacedemo.data.Module.NetMoudle;
import com.example.quchwe.qqspacedemo.data.source.remote.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quchwe on 2016/9/5 0005.
 */

@Singleton
@Component(modules = {NetMoudle.class})
public interface NetComponent {
    void inject(RemoteDataSource dataSource);
}
