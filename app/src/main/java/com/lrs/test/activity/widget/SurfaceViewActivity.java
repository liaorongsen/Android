package com.lrs.test.activity.widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;

import com.lrs.test.R;

public class SurfaceViewActivity extends Activity {

    private SurfaceView surfaceView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceview);
    }
}
