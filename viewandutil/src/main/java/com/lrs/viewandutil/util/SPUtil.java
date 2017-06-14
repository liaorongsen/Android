package com.lrs.viewandutil.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wb-lrs192703 on 2017/6/14.
 */

public class SPUtil {

    private static String SP_KEY = "com.lrs.test";
    private static final String ENV_MODE = "env_mode";

    private static SPUtil instance = new SPUtil();
    private SharedPreferences mSharedPreferences;

    private void RFSharedPreference() {
    }

    public static SPUtil getInstance() {
        return instance;
    }

    public void init(Context appContext) {
        if (appContext == null)
            throw new IllegalArgumentException("context should not be null!");

        mSharedPreferences = appContext.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE | Context.MODE_MULTI_PROCESS);
    }

    public void storeCount(int count) {
        SharedPreferences.Editor shareData = mSharedPreferences.edit();
        shareData.putInt("count", count);
        shareData.apply();
    }

    public int getCount() {
        return mSharedPreferences.getInt("count", -1);
    }
}
