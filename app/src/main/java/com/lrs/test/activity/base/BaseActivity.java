package com.lrs.test.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;

import com.lrs.test.activity.main.LayoutMapping;
import com.lrs.viewandutil.util.LogUtil;

/**
 * Created by wb-lrs192703 on 2017/6/13.
 */

public class BaseActivity extends AppCompatActivity {

    public static final String EXTRA_KEY = "KEY";

    public static final String EXTRA_KEY_1 = "KEY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String key = getIntent().getStringExtra(EXTRA_KEY);
        if (!TextUtils.isEmpty(key)) {
            int layoutId = LayoutMapping.getLayoutId(key);
            if (layoutId > 0)
                setContentView(LayoutMapping.getLayoutId(key));
        }

        LogUtil.e(getClass(), "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();


        LogUtil.e(getClass(), "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();


        LogUtil.e(getClass(), "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.e(getClass(), "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.e(getClass(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.e(getClass(), "onDestroy");
    }

    protected void nav(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.e(getClass(), "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.e(getClass(), "onTouchEvent");
        return super.onTouchEvent(event);
    }
}
