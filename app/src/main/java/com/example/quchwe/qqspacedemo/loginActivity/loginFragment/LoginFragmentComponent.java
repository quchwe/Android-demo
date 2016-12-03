package com.example.quchwe.qqspacedemo.loginActivity.loginFragment;

import android.app.Application;

import com.example.quchwe.qqspacedemo.ApplicationModule;
import com.example.quchwe.qqspacedemo.data.Componet.DataComponent;
import com.example.quchwe.qqspacedemo.loginActivity.LoginActivity;
import com.example.quchwe.qqspacedemo.util.FragmentScoped;

import dagger.Component;

/**
 * Created by quchwe on 2016/9/7 0007.
 */
@FragmentScoped
@Component(dependencies = DataComponent.class,modules ={ LoginPresenterModule.class, ApplicationModule.class})
public interface LoginFragmentComponent {
    void inject(LoginActivity activity);
}
