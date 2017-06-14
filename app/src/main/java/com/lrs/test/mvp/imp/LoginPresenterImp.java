package com.lrs.test.mvp.imp;

import com.lrs.test.mvp.inter.LoginPresenter;
import com.lrs.test.mvp.inter.LoginViewWatcher;

/**
 * Created by wb-lrs192703 on 2017/6/14.
 */

public class LoginPresenterImp implements LoginPresenter, LoginBizImp.OnLoginResponseListener {

    private LoginViewWatcher mLoginView;
    private LoginBizImp mLoginBiz;


    public LoginPresenterImp(LoginViewWatcher mLoginView) {
        this.mLoginView = mLoginView;
        this.mLoginBiz = new LoginBizImp(this);
    }

    @Override
    public void login(String n, String p) {
        mLoginView.preLogin();
        if (mLoginBiz != null) {
            mLoginBiz.login(n, p);
        }
    }


    @Override
    public void onSuccess() {
       mLoginView.loginSucc();

    }

    @Override
    public void onError() {
     mLoginView.loginError();
    }
}
