package com.lrs.test.mvp.imp;

import android.text.TextUtils;

import com.lrs.test.mvp.inter.LoginBiz;

/**
 * 模拟网络请求
 * Created by wb-lrs192703 on 2017/6/14.
 */

public class LoginBizImp implements LoginBiz {


    private OnLoginResponseListener l;

    public LoginBizImp(OnLoginResponseListener l) {
        this.l = l;
    }

    @Override
    public void login(String name, String pass) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pass)) {
            if (l != null) {
                l.onError();
            }
        } else {
            l.onSuccess();
        }

    }

    public interface OnLoginResponseListener {
        void onSuccess();

        void onError();
    }

}
