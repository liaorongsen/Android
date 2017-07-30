package com.lrs.test.activity.widget;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lrs.test.R;
import com.lrs.test.activity.base.BaseActivity;
import com.lrs.viewandutil.widget.CustomDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DatePickerActivity extends BaseActivity implements View.OnClickListener {


    private RelativeLayout selectDate, selectTime;
    private TextView currentDate, currentTime;
    private CustomDatePicker customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        selectTime = (RelativeLayout) findViewById(R.id.selectTime);
        selectTime.setOnClickListener(this);
        selectDate = (RelativeLayout) findViewById(R.id.selectDate);
        selectDate.setOnClickListener(this);
        currentDate = (TextView) findViewById(R.id.currentDate);
        currentTime = (TextView) findViewById(R.id.currentTime);

        initDatePicker();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.selectDate:
                customDatePicker1.show(currentDate.getText().toString());
                break;
            case R.id.selectTime:
                customDatePicker2.show(currentTime.getText().toString());
                break;
        }
    }

    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        currentDate.setText(now.split(" ")[0]);
        currentTime.setText(now);

        customDatePicker1 = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) {
                currentDate.setText(time.split(" ")[0]);
            }
        }, "2010-01-01 00:00", now);
        customDatePicker1.showSpecificTime(false);
        customDatePicker1.setIsLoop(false);
        customDatePicker2 = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) {
                currentTime.setText(time);
            }
        }, "2010-01-01 00:00", now);
        customDatePicker2.showSpecificTime(true);
        customDatePicker2.setIsLoop(true);
    }

}
