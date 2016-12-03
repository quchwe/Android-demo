package com.example.quchwe.qqspacedemo.data.Module;



import com.example.quchwe.qqspacedemo.data.source.remote.Api.ConnectService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by quchwe on 2016/9/5 0005.
 */

@Module
public class NetMoudle {
    private static final String BASE_URL= "http://192.168.0.5:8080";
    private static final int DEFAULT_TIME=8;

    // Dagger will only look for methods annotated with @Provides

        @Singleton
        @Provides
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Singleton
    @Provides
    public Retrofit retrofit(RxJavaCallAdapterFactory callAdapterFactory, GsonConverterFactory gsonConverterFactory, OkHttpClient client){
       Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build();
        return retrofit;
    }

    @Singleton
    @Provides
    protected RxJavaCallAdapterFactory getCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Singleton
    @Provides
    protected GsonConverterFactory getGsonConvertFactory() {
        return GsonConverterFactory.create();
    }


    @Provides
    ConnectService getService(Retrofit retrofit){
        return retrofit.create(ConnectService.class);
    }
    @Singleton
    @Provides
    OkHttpClient getClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return  new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(DEFAULT_TIME, TimeUnit.SECONDS)
                .build();
    }
}
