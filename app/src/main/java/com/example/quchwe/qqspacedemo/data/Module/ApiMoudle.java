package com.example.quchwe.qqspacedemo.data.Module;

import com.example.quchwe.qqspacedemo.data.source.remote.Api.ConnectService;

import retrofit2.Retrofit;

/**
 * Created by quchwe on 2016/9/5 0005.
 */

public class ApiMoudle {

    ConnectService getService(Retrofit retrofit){
        return retrofit.create(ConnectService.class);
    }
}
