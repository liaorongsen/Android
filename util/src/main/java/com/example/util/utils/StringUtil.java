package com.example.util.utils;

import android.widget.TextView;

/**
 * Created by wb-lrs192703 on 2017/6/14.
 */

public class StringUtil {

    public static String getText(TextView v) {
        return v == null ? "" : v.getText().toString();
    }
}
