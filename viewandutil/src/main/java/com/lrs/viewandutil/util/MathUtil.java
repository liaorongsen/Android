package com.lrs.viewandutil.util;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/27.
 */

public class MathUtil {

    public static List<?> copyToList(Set<?> set) {
        List<Object> list = new ArrayList<>();
        if (set == null)
            return list;
        for (Object next : set) {
            list.add(next);
        }
        return list;
    }

    /**
     * dp转px
     *
     * @return
     */
    public static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * px转dp
     *
     * @return
     */
    public static int px2dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }
}
