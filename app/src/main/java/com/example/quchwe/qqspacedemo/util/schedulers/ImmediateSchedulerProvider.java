package com.example.quchwe.qqspacedemo.util.schedulers;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Implementation of the {@link BaseSchedulerProvider} making all {@link Scheduler}s immediate.
 */
@Singleton
@Module
public class ImmediateSchedulerProvider implements BaseSchedulerProvider {

    @NonNull
    @Override

    public Scheduler computation() {
        return Schedulers.immediate();
    }

    @NonNull
    @Override
    @Provides
    public Scheduler io() {
        return Schedulers.immediate();
    }

    @NonNull
    @Override
    @Provides
    public Scheduler ui() {
        return Schedulers.immediate();
    }
}
