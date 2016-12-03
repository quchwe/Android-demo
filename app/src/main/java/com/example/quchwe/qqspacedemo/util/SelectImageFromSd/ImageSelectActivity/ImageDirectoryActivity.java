package com.example.quchwe.qqspacedemo.util.SelectImageFromSd.ImageSelectActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.quchwe.qqspacedemo.R;
import com.example.quchwe.qqspacedemo.base.BaseActivity;
import com.example.quchwe.qqspacedemo.util.SelectImageFromSd.AllPhotoActivity.AllIPhotosActivity;
import com.example.quchwe.qqspacedemo.util.SelectImageFromSd.PreviewPhotoPagerActivity;
import com.example.quchwe.qqspacedemo.util.album.ImageBucket;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageDirectoryActivity extends BaseActivity implements ImageDirectoryContract.View{


    private ImageDirectoryContract.Presenter mPresenter;

    @Bind(R.id.rv_images_directory)
    RecyclerView directoryList;
    ImageDirectoryAdapter adapter;
    private ArrayList<String> selectedImages = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_directory);
        ButterKnife.bind(this);
        mPresenter =    new ImageDirctoryPresenter(this,this);
        mPresenter.setImageBucket();
        selectedImages = getIntent().getStringArrayListExtra(PreviewPhotoPagerActivity.SELECTED_PICTURE_PATHES);
    }

    @Override
    public void setImageDirectory(List<ImageBucket> list) {
        adapter = new ImageDirectoryAdapter(this,list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        directoryList.setLayoutManager(manager);
        directoryList.setAdapter(adapter);
        directoryList.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void setPresenter(@Nullable ImageDirectoryContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    public void toAllPhotoActivity(ArrayList<String> paths){
        Intent intent = new Intent(this,AllIPhotosActivity.class);
        intent.putExtra(AllIPhotosActivity.ALL_IMAGES,paths);
        intent.putExtra(AllIPhotosActivity.SELECTED_IMAGE,selectedImages);
        Log.d("ImageDir",selectedImages.size()+"");
        startActivity(intent);
        finish();
    }

    @Override
    public void finish() {

        super.finish();
    }
}
