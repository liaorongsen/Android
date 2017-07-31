package com.lrs.test.activity.widget;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;

import com.lrs.test.R;
import com.lrs.test.activity.base.BaseActivity;
import com.lrs.viewandutil.util.ToastUtil;

import java.util.Calendar;

public class DatePickActivity2 extends BaseActivity implements View.OnClickListener {

    private DatePicker datePicker;


    private CalendarView mCalderView;

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCalderView = (CalendarView) findViewById(R.id.calderView);
        mCalderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                ToastUtil.show(getApplication(), year + "年" + month + "月" + dayOfMonth + "日");
            }
        });
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        datePicker.setOnClickListener(this);
        Calendar cl = Calendar.getInstance();
        int year = cl.get(Calendar.YEAR);
        int month = cl.get(Calendar.MONTH);
        int dayOfMonth = cl.get(Calendar.DAY_OF_MONTH);

        datePicker.init(year, month, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                ToastUtil.show(getApplication(), year + "年" + monthOfYear + "月" + dayOfMonth + "日");
            }
        });
    }


    private void showDatePicker(boolean showDatePicker) {

        datePicker.setVisibility(showDatePicker ? View.VISIBLE : View.GONE);
        mCalderView.setVisibility(showDatePicker ? View.GONE : View.VISIBLE);
        mButton.setText(showDatePicker ? "CalderView" : "DatePicker");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.datePicker) {
            final int year = datePicker.getYear();
            final int month = datePicker.getMonth();
            final int dayOfMonth = datePicker.getDayOfMonth();
            ToastUtil.show(getApplication(), year + "年" + month + "月" + dayOfMonth + "日");
        } else if (id == R.id.button) {

            if (mCalderView.getVisibility() == View.VISIBLE) {
                showDatePicker(true);
            } else {
                showDatePicker(false);
            }
        }
    }
}
