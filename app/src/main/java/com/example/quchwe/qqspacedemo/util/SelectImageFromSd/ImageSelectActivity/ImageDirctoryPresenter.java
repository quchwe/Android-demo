package com.example.quchwe.qqspacedemo.util.SelectImageFromSd.ImageSelectActivity;

import android.content.Context;

import com.example.quchwe.qqspacedemo.util.album.AlbumHelper;
import com.example.quchwe.qqspacedemo.util.album.ImageBucket;

import java.util.List;


/**
 * Created by quchwe on 2016/8/12 0012.
 */

public class ImageDirctoryPresenter  implements ImageDirectoryContract.Presenter{


    private final ImageDirectoryContract.View mView;
    private final Context mContext;
    public ImageDirctoryPresenter(Context context, ImageDirectoryContract.View view){
        this.mView = view;
        this.mContext = context;
        mView.setPresenter(this);
    }

    @Override
    public void setImageBucket() {
        AlbumHelper helper = AlbumHelper.getHelper();

        helper.init(mContext);

        List<ImageBucket> imageBuckets =  helper.getImagesBucketList(true);


        mView.setImageDirectory(imageBuckets);
    }


    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }
}
