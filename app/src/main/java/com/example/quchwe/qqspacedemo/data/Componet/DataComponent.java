package com.example.quchwe.qqspacedemo.data.Componet;

import com.example.quchwe.qqspacedemo.ApplicationModule;
import com.example.quchwe.qqspacedemo.data.Module.DataResiposityMoudle;
import com.example.quchwe.qqspacedemo.data.Module.ScherlerMoudle;
import com.example.quchwe.qqspacedemo.data.source.DataResposity;
import com.example.quchwe.qqspacedemo.util.schedulers.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quchwe on 2016/9/7 0007.
 */
@Singleton
@Component(modules = {DataResiposityMoudle.class, ApplicationModule.class, ScherlerMoudle.class})

public interface DataComponent {
    DataResposity getResposity();
}
