package com.lrs.test.mvp;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lrs.test.R;
import com.lrs.test.application.MyApp;
import com.lrs.test.mvp.imp.LoginPresenterImp;
import com.lrs.test.mvp.inter.LoginPresenter;
import com.lrs.test.mvp.inter.LoginViewWatcher;
import com.lrs.viewandutil.util.StringUtil;
import com.lrs.viewandutil.util.ToastUtil;

public class LoginActivity extends AppCompatActivity implements LoginViewWatcher {


    private TextInputEditText mUserNameEt, mPassWordEt;
    private Button mLogin;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUserNameEt = (TextInputEditText) findViewById(R.id.username_et);
        mPassWordEt = (TextInputEditText) findViewById(R.id.userpass_et);
        mLogin = (Button) findViewById(R.id.login);
        mPresenter = new LoginPresenterImp(this);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login(StringUtil.getText(mUserNameEt), StringUtil.getText(mPassWordEt));
            }
        });
    }


    @Override
    public void preLogin() {

    }


    @Override
    public void loginSucc() {
        ToastUtil.show(MyApp.getApp(), "Login Success");
    }

    @Override
    public void loginError() {
        ToastUtil.show(MyApp.getApp(), "Login Error");
    }
}
