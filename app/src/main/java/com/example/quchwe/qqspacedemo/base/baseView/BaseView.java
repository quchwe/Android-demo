package com.example.quchwe.qqspacedemo.base.baseView;

import com.example.quchwe.qqspacedemo.base.basePresenter.BasePresenter;

/**
 * Created by quchwe on 2016/9/1 0001.
 */

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
    void showConnectFailed();

}
