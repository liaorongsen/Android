package com.lrs.test.activity.widget;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lrs.test.R;
import com.lrs.test.activity.base.BaseActivity;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

public class MaterialCalendarViewActivity extends BaseActivity implements View.OnClickListener {


    private MaterialCalendarView materialCalendarView;
    private Button mMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        materialCalendarView = (MaterialCalendarView) findViewById(R.id.material_calendarview);
        mMode = (Button) findViewById(R.id.mode);
        mMode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.mode) {
            materialCalendarView.state().edit().setCalendarDisplayMode(CalendarMode.WEEKS).commit();
        }
    }
}
