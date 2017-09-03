package com.lrs.test.application;

import android.app.Application;

import com.lrs.test.R;
import com.lrs.test.activity.common.GlideTestActivity;
import com.lrs.test.activity.main.LayoutMapping;
import com.lrs.test.activity.rn.ReactNativeActivity;
import com.lrs.test.activity.widget.DatePickActivity2;
import com.lrs.test.activity.widget.DatePickerActivity;
import com.lrs.test.activity.widget.DatePickerDialogActivity;
import com.lrs.test.activity.widget.MaterialCalendarViewActivity;
import com.lrs.test.activity.widget.SurfaceViewActivity;
import com.lrs.test.activity.widget.UiStudyActivity;
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
        LogUtil.e(getClass(), "onCreate");
    }

    private void initLayoutMap() {
        LayoutMapping.put("ReactNative", ReactNativeActivity.class, Integer.MIN_VALUE);
        LayoutMapping.put("Glide", GlideTestActivity.class, R.layout.activity_gilde);
        LayoutMapping.put("DatePicker", DatePickerActivity.class, R.layout.activity_datepicker);
        LayoutMapping.put("DatePicker2", DatePickActivity2.class, R.layout.activity_date_picker);
        LayoutMapping.put("MaterialCalendarView", MaterialCalendarViewActivity.class, R.layout.activity_material_calendarview);
        LayoutMapping.put("DatePickerDialog", DatePickerDialogActivity.class, R.layout.activity_datepickerdialog);
        LayoutMapping.put("SurfaceView", SurfaceViewActivity.class, R.layout.activity_surface_view);
        LayoutMapping.put("UiStudy", UiStudyActivity.class, R.layout.activity_ui_study);
    }


    public static MyApp getApp() {
        return mApp;
    }
}
