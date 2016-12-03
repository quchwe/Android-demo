package com.example.quchwe.qqspacedemo.loginActivity.loginFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.quchwe.qqspacedemo.data.Entity.Things;
import com.example.quchwe.qqspacedemo.data.Entity.User;
import com.example.quchwe.qqspacedemo.data.source.DataResposity;
import com.example.quchwe.qqspacedemo.loginActivity.loginFragment.LoginContract;

import java.util.List;

import javax.inject.Inject;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by quchwe on 2016/9/7 0007.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private final DataResposity mResposity;
    private final LoginContract.View mView;
    private final CompositeSubscription mCompositeSubscription;
    private final Context mContext;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Inject
    public LoginPresenter(@NonNull Context context,@NonNull DataResposity resposity,@NonNull LoginContract.View view){
        this.mResposity = resposity;
        this.mView = view;
        this.mContext = context;
        mCompositeSubscription = new CompositeSubscription();
        mView.setPresenter(this);
       preferences = context.getSharedPreferences("LoginShare",Context.MODE_PRIVATE);
        editor = preferences.edit();
    }
    @Override
    public void onLogin(int userId,String password) {
        Log.d(userId+"",password);
       Subscription subscription = mResposity.getUser(userId+"",password).subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {
                mView.showLoginSuccess();
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                mView.showLoginFailed();
            }

            @Override
            public void onNext(User user) {
                Log.d("登录用户",user.getUserName());
                mResposity.saveUsers(user);
            }
        });
        mCompositeSubscription.add(subscription);
        mResposity.getThingss(1,1,1234556).subscribe(new Subscriber<List<Things>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Things> thingses) {
                Log.d("this",thingses.get(0).getHeadImage());
            }
        });
    }



    @Override
    public void clearLogin() {
            editor.clear();
    }

    @Override
    public void saveLogin(int userId,String password) {
       editor.putBoolean("saveLogin",true);
        editor.putInt("userIdEdit",userId);
        editor.putString("passwordEdit",password);
        editor.commit();
    }

    @Override
    public void onSignUp() {

    }



    @Override
    public void replaceUser() {

    }

    @Override
    public void loadHeadImage() {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {
        mCompositeSubscription.clear();
    }

    @Override
    public void setPassword(){
       int userId = preferences.getInt("userIdEdit",-1);
        String password = preferences.getString("passwordEdit",null);
        mView.remeberPassword(userId,password);
    }
}
