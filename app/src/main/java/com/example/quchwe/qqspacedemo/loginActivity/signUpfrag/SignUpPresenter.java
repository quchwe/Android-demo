package com.example.quchwe.qqspacedemo.loginActivity.signUpfrag;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.quchwe.qqspacedemo.data.source.DataResposity;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by quchwe on 2016/9/10 0010.
 */

public class SignUpPresenter implements SignContract.Presenter {

    private final SignContract.View mView;
    private final DataResposity mResposity;
    private CompositeSubscription mSubScriprion;

    @Inject
    public SignUpPresenter(@NonNull DataResposity resposity,@NonNull SignContract.View view){
        this.mResposity = resposity;
        this.mView = view;
        mSubScriprion = new CompositeSubscription();
        mView.setPresenter(this);
    }


    @Override
    public void signUp(String userName, String userPassword, String headImage) {
       Subscription subscription =  mResposity.signUp(userName,userPassword,headImage)
                    .subscribe(new Subscriber<String>() {
                        @Override
                        public void onCompleted() {
                            Log.d("sign","completed");
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(String s) {
                            if (s.equals("success")){
                            mView.showSignSuccess();
                            }
                            else mView.showSignFalied();
                        }
                    });
        mSubScriprion.add(subscription);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {
        mSubScriprion.clear();
    }
}
