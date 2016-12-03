package com.example.quchwe.qqspacedemo.loginActivity.signUpfrag;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.bumptech.glide.Glide;
import com.example.quchwe.qqspacedemo.AppAplication;
import com.example.quchwe.qqspacedemo.R;
import com.example.quchwe.qqspacedemo.base.BaseFragment;
import com.example.quchwe.qqspacedemo.util.DialogUtils;
import com.example.quchwe.qqspacedemo.util.LocationUtil;
import com.example.quchwe.qqspacedemo.util.SelectImageFromSd.AllPhotoActivity.AllIPhotosActivity;
import com.example.quchwe.qqspacedemo.util.Widget.CirecleImage;

import java.io.File;
import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by quchwe on 2016/9/10 0010.
 */

public class SignUpFragment extends BaseFragment<SignContract.Presenter> implements SignContract.View {
        public static final String TAG= "SignUpFragment";

    @Inject
    SignUpPresenter signUpPresenter;
    public static SignUpFragment newInstance() {

        Bundle args = new Bundle();

        SignUpFragment fragment = new SignUpFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static final int TAKE_PHOTO = 1;
    public static final int SELECT_PHOTO = 0;
    private String headImagePath;
    Uri came_photo_path = null;
    @Bind(R.id.et_userName)
    EditText editUserName;
    @Bind(R.id.et_password)
    EditText editPassword;
    @Bind(R.id.iv_head_image)
    CirecleImage headImage;
    @Bind(R.id.btn_signUp)
    Button signUpBtn;
    @Bind(R.id.back)
    Button backBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_sign_up, container, false);
        ButterKnife.bind(this, root);
        DaggerSignUpComponent.builder()
                .dataComponent(((AppAplication)getActivity().getApplication()).getResposityComponent())
                .signUpPresenterModule(new SignUpPresenterModule(this))
                .build().inject(this);

        return root;
    }

    @OnClick({R.id.back, R.id.btn_signUp, R.id.iv_head_image})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_signUp:
                signUp();
                break;
            case R.id.iv_head_image:
                showSetHeadImageDialog();
                Log.d("点击","头像");
                break;
        }
    }

    private void signUp() {
        String userName = editUserName.getText().toString();
        String password = editPassword.getText().toString();

        signUpPresenter.signUp(userName,password,headImagePath);

    }

    @Override
    public void showSignSuccess() {

    }

    @Override
    public void showSignFalied() {

    }

    @Override
    public void setPresenter(SignContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showConnectFailed() {

    }

    public void showSetHeadImageDialog() {
        final DialogUtils.DialogMenu2 dialogMenu2 = new DialogUtils.DialogMenu2(getContext());
        dialogMenu2.addMenuItem("拍照");
        dialogMenu2.addMenuItem("从手机相册选择");
        Log.d("tfrc","lll");
        dialogMenu2.setMenuListener(new DialogUtils.DialogMenu2.MenuListener() {
            @Override
            public void onItemSelected(int position, String item) {
                if (position == 0) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    came_photo_path = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "headImage.jpg"));
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, came_photo_path);
                    intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
                    startActivityForResult(intent, TAKE_PHOTO);
                }
                if (position == 1) {
                    Intent k = new Intent(getContext(),AllIPhotosActivity.class);
                    startActivityForResult(k,SELECT_PHOTO);
                    //getActivity().startActivityForResult(new Intent(getContext(), AllIPhotosActivity.class));
                }
            }

            @Override
            public void onCancel() {
                dialogMenu2.dismiss();
            }
        });
        dialogMenu2.initView();
        dialogMenu2.show();
        LocationUtil.bottom_FillWidth(getActivity(), dialogMenu2);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ;
        if (requestCode == TAKE_PHOTO&&resultCode== Activity.RESULT_OK){
            headImagePath = came_photo_path.toString();
            Glide.with(getContext())
                    .load(came_photo_path)
                    .into(headImage);
        }
        if (requestCode==SELECT_PHOTO&&resultCode==Activity.RESULT_OK){
            ArrayList<String> selectPaths = data.getStringArrayListExtra(AllIPhotosActivity.SELECTED_IMAGE);

            if (selectPaths.size()>0){
                headImagePath = selectPaths.get(0);
                Glide.with(getContext())
                        .load(headImagePath)
                        .into(headImage);
            }
        }
    }
}
