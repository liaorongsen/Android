package com.lrs.test.activity.common.wechat;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.lrs.test.R;
import com.lrs.test.activity.base.BaseActivity;
import com.lrs.viewandutil.util.ToastUtil;

public class WeChatMainActivity extends BaseActivity implements TextView.OnEditorActionListener {


    private EditText mEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEdit = (EditText) findViewById(R.id.edit);
        mEdit.setOnEditorActionListener(this);
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        ToastUtil.show(this, v.toString() + actionId + event);
        return false;
    }
}
