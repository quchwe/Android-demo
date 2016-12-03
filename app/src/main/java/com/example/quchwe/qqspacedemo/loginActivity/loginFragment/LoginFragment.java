package com.example.quchwe.qqspacedemo.loginActivity.loginFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quchwe.qqspacedemo.R;
import com.example.quchwe.qqspacedemo.base.BaseFragment;
import com.example.quchwe.qqspacedemo.loginActivity.LoginActivity;
import com.example.quchwe.qqspacedemo.loginActivity.signUpfrag.SignUpFragment;
import com.example.quchwe.qqspacedemo.util.Widget.CirecleImage;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by quchwe on 2016/9/7 0007.
 */

public class LoginFragment extends BaseFragment<LoginContract.Presenter> implements LoginContract.View,View.OnClickListener {

    public static final String Tag = "LoginFragment";

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Bind(R.id.iv_head_image)
    CirecleImage headImage;
    @Bind(R.id.et_userId)
    EditText userIdEdit;
    @Bind(R.id.et_password)
    EditText passwordEdit;
    @Bind(R.id.btn_signUp)
    Button signUp;
    @Bind(R.id.btn_login)
    Button login;
    CheckBox rememberPass;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_login,container,false);
        ButterKnife.bind(this,root);
        login = (Button)root.findViewById(R.id.btn_login);
        userIdEdit = (EditText)root.findViewById(R.id.et_userId);
        passwordEdit = (EditText)root.findViewById(R.id.et_password);
        rememberPass = (CheckBox)root.findViewById(R.id.ck_remember);

        login.setOnClickListener(this);

        mPresenter.setPassword();
        return root;
    }

    @Override
    public void showLoginSuccess() {

    }

    @Override
    public void showLoginFailed() {

    }

    @Override
    public void onLogin() {

    }

    @Override
    public void onLogin(int userId, String password) {
        mPresenter.onLogin(userId,password);
    }

    @Override
    public void remeberPassword(int userId, String password) {
        if (userId==-1){
            return;
        }
        userIdEdit.setText(userId);
        passwordEdit.setText(password);
    }

    @Override
    public void onSignUp() {

    }

    @Override
    public void setPresenter(LoginContract.Presenter p) {
            this.mPresenter = p;
    }

    @Override
    public void showConnectFailed() {

    }

    @OnClick({R.id.btn_login,R.id.btn_signUp})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
              login();
                break;
            case R.id.btn_signUp:
                SignUpFragment signUpFragment = ((LoginActivity)mActivity).getmSignView();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_right,
                                R.anim.slide_in_left, R.anim.slide_out_left)
                        .replace(R.id.fl_login,signUpFragment,SignUpFragment.TAG)
                        .addToBackStack(LoginFragment.TAG)
                        .commit();
                break;

        }
    }
private void login(){
    String id = userIdEdit.getText().toString();
    String pass =  passwordEdit.getText().toString();
    Log.d(id,pass);
    if ((id!=null&&!id.equals(""))&&(pass!=null&&!pass.equals(""))){
        try {
            int userId = Integer.valueOf(id);
            onLogin(userId,pass);
            if (rememberPass.isChecked()){
                mPresenter.saveLogin(userId,pass);
            }else {
                mPresenter.clearLogin();
            }
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getContext(),"输入错误",Toast.LENGTH_SHORT).show();
        }
    }
}
}
