package com.example.quchwe.qqspacedemo.util.SelectImageFromSd.ImageSelectActivity;



import com.example.quchwe.qqspacedemo.base.basePresenter.BasePresenter;
import com.example.quchwe.qqspacedemo.util.album.ImageBucket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quchwe on 2016/8/12 0012.
 */

public interface ImageDirectoryContract {

    interface Presenter extends BasePresenter {
       void setImageBucket();

    }

    interface View {
        void setImageDirectory(List<ImageBucket> list);
        void setPresenter(Presenter presenter);
        void toAllPhotoActivity(ArrayList<String> paths);
    }

}
