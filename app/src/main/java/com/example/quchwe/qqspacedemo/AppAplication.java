package com.example.quchwe.qqspacedemo;

import android.app.Application;
import android.content.Context;
//
import com.example.quchwe.qqspacedemo.data.Componet.DaggerDataComponent;
import com.example.quchwe.qqspacedemo.data.Componet.DaggerNetComponent;
import com.example.quchwe.qqspacedemo.data.Componet.DataComponent;
import com.example.quchwe.qqspacedemo.data.Componet.NetComponent;
import com.example.quchwe.qqspacedemo.data.Module.DataResiposityMoudle;
import com.example.quchwe.qqspacedemo.data.Module.NetMoudle;
import com.example.quchwe.qqspacedemo.data.Module.ScherlerMoudle;
import com.example.quchwe.qqspacedemo.util.schedulers.SchedulerProvider;

/**
 * Created by quchwe on 2016/9/6 0006.
 */

public class AppAplication extends Application {
    private NetComponent mComponent;

    private DataComponent mDataComponent;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mComponent = DaggerNetComponent.builder().netMoudle(new NetMoudle()).
                build();

        mDataComponent = DaggerDataComponent.builder().
                scherlerMoudle(new ScherlerMoudle(new SchedulerProvider())).
                dataResiposityMoudle(new DataResiposityMoudle()).
                applicationModule(new ApplicationModule(mContext))
                .build();
    }

    public static NetComponent getComponent() {
        return ((AppAplication) mContext.getApplicationContext()).mComponent;
    }

    public DataComponent getResposityComponent(){
        return mDataComponent;
    }
}
