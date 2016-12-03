package com.example.quchwe.qqspacedemo.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.quchwe.qqspacedemo.R;

/**
 * Created by quchwe on 2016/9/7 0007.
 */

public class BaseActivity extends AppCompatActivity {
    protected FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFragmentManager = getSupportFragmentManager();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
}
