package com.example.quchwe.qqspacedemo.loginActivity.signUpfrag;

import dagger.Module;
import dagger.Provides;

/**
 * Created by quchwe on 2016/9/10 0010.
 */

@Module
public class SignUpPresenterModule {

    private SignContract.View mView;
    public SignUpPresenterModule(SignContract.View view){
        this.mView = view;
    }

    @Provides
    SignContract.View getmView(){
        return mView;
    }
}
