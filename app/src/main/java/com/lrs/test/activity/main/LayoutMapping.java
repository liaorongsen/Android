package com.lrs.test.activity.main;

import android.app.Activity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/27.
 */

public class LayoutMapping {

    private static Map<String, ItemTarget> mLayoutMap
            = new HashMap<String, ItemTarget>();


    public static void put(String name, Class<? extends Activity> cls, int id) {
        ItemTarget itemTarget = new ItemTarget(cls, id);
        mLayoutMap.put(name, itemTarget);
    }

    public static Class<? extends Activity> get(String key) {
        ItemTarget itemTarget = mLayoutMap.get(key);
        return itemTarget.getCls();
    }

    public static int getLayoutId(String key) {
        ItemTarget itemTarget = mLayoutMap.get(key);
        return itemTarget.getLayoutResId();
    }

    public static Set<String> getAllKeys() {
        return mLayoutMap.keySet();
    }

}
