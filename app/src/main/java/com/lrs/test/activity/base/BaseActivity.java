package com.lrs.test.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lrs.viewandutil.util.LogUtil;

/**
 * Created by wb-lrs192703 on 2017/6/13.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.e(getClass().getSimpleName() + "-->" + "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.e(getClass().getSimpleName() + "-->" + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.e(getClass().getSimpleName() + "-->" + "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.e(getClass().getSimpleName() + "-->" + "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.e(getClass().getSimpleName() + "-->" + "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.e(getClass().getSimpleName() + "-->" + "onDestroy");
    }

    protected void nav(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}