package com.lrs.test.application;

import android.app.Application;

import com.example.util.utils.LogUtil;
import com.example.util.utils.SPUtil;


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
        LogUtil.e(getClass(), "onCreate");
    }



    public static MyApp getApp() {
        return mApp;
    }
}
