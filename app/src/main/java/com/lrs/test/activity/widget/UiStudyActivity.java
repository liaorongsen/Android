package com.lrs.test.activity.widget;

import android.app.Activity;
import android.os.Bundle;

import com.lrs.test.R;
import com.lrs.test.activity.base.BaseActivity;
import com.lrs.viewandutil.widget.MLayout;
import com.lrs.viewandutil.widget.MView;
import com.lrs.viewandutil.widget.NavigationBar;

public class UiStudyActivity extends BaseActivity {

    private MLayout mLayout;

    private MView mView;

    private NavigationBar navigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayout = (MLayout) findViewById(R.id.mlayout);
        mView = (MView) findViewById(R.id.mview);

        navigationBar = (NavigationBar) findViewById(R.id.navbar);
        navigationBar.setmExpandH(1000);
        navigationBar.setTabCount(10);
    }


}
