package com.lrs.test.activity.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lrs.test.activity.base.BaseActivity;
import com.lrs.test.R;
import com.lrs.test.activity.common.StepCounterActivity;
import com.lrs.test.activity.rn.ReactNativeActivity;
import com.lrs.test.activity.rx.RxActivity;
import com.lrs.test.activity.widget.ImagePickerActivity;
import com.lrs.test.mvp.LoginActivity;
import com.lrs.viewandutil.util.MathUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private ListView mMainList;
    private MainAdapter mAdapter;
    private List<String> mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mMainList = (ListView) findViewById(R.id.main_list);
        mMainList.setOnItemClickListener(this);
        mData = (List<String>) MathUtil.copyToList(LayoutMapping.getAllKeys());
        mAdapter = new MainAdapter(this, mData);
        mMainList.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String clickItem = mData.get(position);
        navTo(clickItem, LayoutMapping.get(clickItem));
    }


    private void navTo(String key, Class<? extends Activity> cls) {

        Intent intent = new Intent(this, cls);
        intent.putExtra(BaseActivity.EXTRA_KEY, key);
        startActivity(intent);
    }
}
