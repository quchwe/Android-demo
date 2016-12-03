package com.example.quchwe.qqspacedemo.data.Module;

import com.example.quchwe.qqspacedemo.util.schedulers.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by quchwe on 2016/9/9 0009.
 */

@Module
public class ScherlerMoudle {
    private final SchedulerProvider provider;
    public ScherlerMoudle(SchedulerProvider provider){
        this.provider = provider;
    }
    @Provides
    SchedulerProvider getProvider(){
        return provider;
    }
}
