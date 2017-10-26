package com.lrs.test.activity.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;

import com.lrs.test.R;
import com.lrs.test.activity.base.BaseActivity;
import com.lrs.viewandutil.widget.MSurfaceView;

public class SurfaceViewActivity extends BaseActivity {

    private MSurfaceView surfaceView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        surfaceView = (MSurfaceView) findViewById(R.id.surfaceview);


       // surfaceView.draw();
    }


}
