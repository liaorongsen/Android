package com.lrs.test.activity.widget;


import android.app.*;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.lrs.test.activity.base.BaseActivity;
import com.lrs.viewandutil.util.CalendarUtil;
import com.lrs.viewandutil.util.ToastUtil;



public class DatePickerDialogActivity extends BaseActivity implements DatePickerDialog.OnDateSetListener {

    private android.app.DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (datePickerDialog == null) {
            datePickerDialog = new DatePickerDialog(this, this, CalendarUtil.getYear(),
                    CalendarUtil.getMonth(), CalendarUtil.getDayOfMonth());
        }
    }


    public void show(View v) {
        if (datePickerDialog.isShowing())
            datePickerDialog.dismiss();
        else
            datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        ToastUtil.show(getApplication(), year + "-" + month + 1 + "-" + dayOfMonth);
    }
}
