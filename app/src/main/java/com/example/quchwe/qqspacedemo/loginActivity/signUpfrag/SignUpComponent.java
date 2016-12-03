package com.example.quchwe.qqspacedemo.loginActivity.signUpfrag;

import com.example.quchwe.qqspacedemo.data.Componet.DataComponent;
import com.example.quchwe.qqspacedemo.loginActivity.LoginActivity;
import com.example.quchwe.qqspacedemo.util.FragmentScoped;

import dagger.Component;

/**
 * Created by quchwe on 2016/9/10 0010.
 */

@FragmentScoped
@Component(dependencies = DataComponent.class,modules = {SignUpPresenterModule.class})
public interface SignUpComponent {
    void inject(SignUpFragment loginActivity);
}
