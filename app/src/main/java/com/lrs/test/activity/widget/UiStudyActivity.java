package com.lrs.test.activity.widget;

import android.app.Activity;
import android.os.Bundle;

import com.lrs.test.R;
import com.lrs.viewandutil.widget.MLayout;
import com.lrs.viewandutil.widget.MView;

public class UiStudyActivity extends Activity {

    private MLayout mLayout;

    private MView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayout = (MLayout) findViewById(R.id.mlayout);
        mView = (MView) findViewById(R.id.mview);
    }




}
