package com.lrs.viewandutil.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by wb-lrs192703 on 2017/6/13.
 */

public class ToastUtil {


    public static void show(Context c, String msg) {
        Toast.makeText(c, msg, Toast.LENGTH_LONG).show();
    }

}
