package com.example.quchwe.qqspacedemo.loginActivity;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;

import com.example.quchwe.qqspacedemo.AppAplication;
import com.example.quchwe.qqspacedemo.ApplicationModule;
import com.example.quchwe.qqspacedemo.R;
import com.example.quchwe.qqspacedemo.base.BaseActivity;
import com.example.quchwe.qqspacedemo.base.BaseFragment;

import com.example.quchwe.qqspacedemo.loginActivity.loginFragment.DaggerLoginFragmentComponent;
import com.example.quchwe.qqspacedemo.loginActivity.loginFragment.LoginContract;
import com.example.quchwe.qqspacedemo.loginActivity.loginFragment.LoginFragment;
import com.example.quchwe.qqspacedemo.loginActivity.loginFragment.LoginPresenter;
import com.example.quchwe.qqspacedemo.loginActivity.loginFragment.LoginPresenterModule;
import com.example.quchwe.qqspacedemo.loginActivity.signUpfrag.SignContract;
import com.example.quchwe.qqspacedemo.loginActivity.signUpfrag.SignUpFragment;
import com.example.quchwe.qqspacedemo.loginActivity.signUpfrag.SignUpPresenter;
import com.example.quchwe.qqspacedemo.util.ActivityUtils;

import javax.inject.Inject;

/**
 * Created by quchwe on 2016/9/7 0007.
 */

public class LoginActivity extends BaseActivity{
    public static final String TAG = "LoginActivity-";
    private LoginContract.View mLoginView;
    private SignContract.View mSignView;


    @Inject
    LoginPresenter mLoginPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initFragments();
        BaseFragment  frag = (BaseFragment) mFragmentManager.findFragmentById(R.id.fl_login);

        if (frag == null) {
            frag = getmLoginView();
            mFragmentManager.beginTransaction().add(R.id.fl_login, frag, BaseFragment.TAG).commit();
        }

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
        DaggerLoginFragmentComponent.builder()
                .dataComponent(((AppAplication)getApplication()).getResposityComponent())
                .applicationModule(new ApplicationModule(getApplication()))
                .loginPresenterModule(new LoginPresenterModule(getmLoginView()
                ))
                .build().inject(this);


    }

    private void initFragments(){
        Fragment frag = null;
        frag = mFragmentManager.findFragmentByTag(LoginFragment.TAG);
        mLoginView = (frag == null) ? LoginFragment.newInstance() : (LoginFragment) frag;
        frag = mFragmentManager.findFragmentByTag(SignUpFragment.TAG);
        mSignView = (frag==null)?SignUpFragment.newInstance():(SignUpFragment) frag;
    }

    public LoginFragment getmLoginView() {
        return (LoginFragment)mLoginView;
    }

    public SignUpFragment getmSignView() {
        return (SignUpFragment)mSignView;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            SignUpFragment signUpFragment = getmSignView();
            signUpFragment.onActivityResult(requestCode,resultCode,data);


    }
}
