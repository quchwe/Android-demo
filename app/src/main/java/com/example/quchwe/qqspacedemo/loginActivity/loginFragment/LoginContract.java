package com.example.quchwe.qqspacedemo.loginActivity.loginFragment;

import com.example.quchwe.qqspacedemo.base.basePresenter.BasePresenter;
import com.example.quchwe.qqspacedemo.base.baseView.BaseView;
import com.example.quchwe.qqspacedemo.data.Entity.User;

/**
 * Created by quchwe on 2016/9/7 0007.
 */

public interface LoginContract {
    interface Presenter extends BasePresenter{
        void onLogin(int userId,String password);
        void saveLogin(int userId,String password);
        void clearLogin();
        void onSignUp();

        void replaceUser();
        void loadHeadImage();

        void setPassword();
    }
    interface View extends BaseView<Presenter>{
        void showLoginSuccess();
        void showLoginFailed();
        void onLogin();

        void onLogin(int userId, String password);
        void remeberPassword(int userId,String password);
        void onSignUp();
    }
}
