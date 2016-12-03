package com.example.quchwe.qqspacedemo;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by quchwe on 2016/9/1 0001.
 */

@Module
public class ApplicationModule {

    private final Context mContext;
    public ApplicationModule(Context context) {
        mContext = context;
    }
    @Provides
    Context provideContext() {
        return mContext;
    }
}
