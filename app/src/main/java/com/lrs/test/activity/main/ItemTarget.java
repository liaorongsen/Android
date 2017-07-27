package com.lrs.test.activity.main;

import android.app.Activity;

/**
 * Created by Administrator on 2017/7/27.
 */

public class ItemTarget {


    private Class<? extends Activity> cls;
    private int layoutResId;

    public ItemTarget(Class<? extends Activity> cls, int layoutResId) {
        this.cls = cls;
        this.layoutResId = layoutResId;
    }

    public Class<? extends Activity> getCls() {
        return cls;
    }

    public void setCls(Class<? extends Activity> cls) {
        this.cls = cls;
    }

    public int getLayoutResId() {
        return layoutResId;
    }

    public void setLayoutResId(int layoutResId) {
        this.layoutResId = layoutResId;
    }
}
