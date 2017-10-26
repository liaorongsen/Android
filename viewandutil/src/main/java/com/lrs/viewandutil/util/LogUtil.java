package com.lrs.viewandutil.util;

import android.util.Log;

/**
 * Created by wb-lrs192703 on 2017/6/13.
 */

public class LogUtil {

    public static void e(Class cls, String msg) {
        Log.e("TAG", cls.getSimpleName() + "-->" + msg);
    }

    public static void e(String msg) {
        Log.e("TAG", msg);
    }


}
