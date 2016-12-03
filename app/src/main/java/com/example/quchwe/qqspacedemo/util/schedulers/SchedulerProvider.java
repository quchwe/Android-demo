package com.example.quchwe.qqspacedemo.util.schedulers;


import android.support.annotation.NonNull;

import javax.inject.Singleton;


import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Provides different types of schedulers.
 */


@Singleton

public class SchedulerProvider implements BaseSchedulerProvider {


    @NonNull
    public Scheduler computation() {
        return Schedulers.computation();
    }


    @NonNull
    public Scheduler io() {
        return Schedulers.io();
    }


    @NonNull
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
