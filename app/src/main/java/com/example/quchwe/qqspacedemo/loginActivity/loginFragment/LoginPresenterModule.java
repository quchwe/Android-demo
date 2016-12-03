package com.example.quchwe.qqspacedemo.loginActivity.loginFragment;

import com.example.quchwe.qqspacedemo.loginActivity.loginFragment.LoginContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by quchwe on 2016/9/7 0007.
 */

@Module
public class LoginPresenterModule {
    private final LoginContract.View mView;

    public LoginPresenterModule(LoginContract.View view){
        this.mView = view;
    }

    @Provides
    LoginContract.View getmView(){
        return mView;
    }
}
