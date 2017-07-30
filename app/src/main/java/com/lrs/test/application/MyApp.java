package com.lrs.test.application;

import android.app.Application;

import com.lrs.test.R;
import com.lrs.test.activity.common.GlideTestActivity;
import com.lrs.test.activity.main.LayoutMapping;
import com.lrs.test.activity.rn.ReactNativeActivity;
import com.lrs.test.activity.widget.DatePickerActivity;
import com.lrs.viewandutil.util.LogUtil;
import com.lrs.viewandutil.util.SPUtil;

/**
 * Created by wb-lrs192703 on 2017/6/13.
 */

public class MyApp extends Application {
    private static MyApp mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = (MyApp) getApplicationContext();
        SPUtil.getInstance().init(getApplicationContext());
        initLayoutMap();
        LogUtil.e(getClass().getSimpleName() + "-->" + "onCreate");
    }

    private void initLayoutMap() {
        LayoutMapping.put("ReactNative", ReactNativeActivity.class, Integer.MIN_VALUE);
        LayoutMapping.put("Glide", GlideTestActivity.class, R.layout.activity_gilde);
        LayoutMapping.put("DatePicker", DatePickerActivity.class, R.layout.activity_datepicker);
    }

    public static MyApp getApp() {
        return mApp;
    }
}
