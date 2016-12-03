package com.example.quchwe.qqspacedemo.util.SelectImageFromSd.AllPhotoActivity;

import com.example.quchwe.qqspacedemo.base.basePresenter.BasePresenter;
import com.example.quchwe.qqspacedemo.base.baseView.BaseView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by quchwe on 2016/8/6 0006.
 */
public interface SeletPhotoContract {
    interface Presenter extends BasePresenter {

        List<String> getAllPicturePath();
        void getAllImageItems();



    }
    interface View extends BaseView<Presenter> {

        void setPicteureSelectCount(int count);

        void toPreview();
        void setRecylerView();
        void currentSelected(String picturePath);
        void setSlectPicturePath(ArrayList<String> paths);
    }
}
