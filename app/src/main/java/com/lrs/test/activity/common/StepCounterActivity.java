package com.lrs.test.activity.common;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lrs.test.R;
import com.lrs.test.activity.base.BaseActivity;
import com.lrs.viewandutil.widget.FlowLayout;

public class StepCounterActivity extends BaseActivity {


    private SensorEvent mEvent;
    private TextView mCountTv;
    private SensorManager sensorManager;
    Sensor sensor;


    private FlowLayout mFlowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);
        // mCountTv = (TextView) findViewById(R.id.tv_step_count);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        mFlowLayout = (FlowLayout) findViewById(R.id.flowlayout);


        LinearLayout.MarginLayoutParams lp = new LinearLayout.LayoutParams(-2, -2);
        lp.setMargins(10, 10, 10, 10);

    }


}
