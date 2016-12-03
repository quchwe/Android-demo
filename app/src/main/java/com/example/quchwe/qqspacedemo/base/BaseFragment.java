package com.example.quchwe.qqspacedemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quchwe.qqspacedemo.base.basePresenter.BasePresenter;

/**
 * Created by quchwe on 2016/9/7 0007.
 */

public class BaseFragment<T extends BasePresenter> extends Fragment{

    public static final String TAG = "BaseFrament";
    protected BaseActivity mActivity;
    protected Context mContext;
    protected T mPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = (BaseActivity) getActivity();
        mContext = mActivity;

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.unSubscribe();
    }

    protected void setmPresenter(T presenter){
        this.mPresenter = presenter;
    }
}
