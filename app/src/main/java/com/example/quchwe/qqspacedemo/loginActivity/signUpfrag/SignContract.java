package com.example.quchwe.qqspacedemo.loginActivity.signUpfrag;

import com.example.quchwe.qqspacedemo.base.basePresenter.BasePresenter;
import com.example.quchwe.qqspacedemo.base.baseView.BaseView;

/**
 * Created by quchwe on 2016/9/10 0010.
 */

public interface SignContract {
    interface Presenter extends BasePresenter{
        void signUp(String userName,String userPassword,String headImage);
    }
    interface View extends BaseView<Presenter>{
        void showSignSuccess();
        void showSignFalied();
    }
}
