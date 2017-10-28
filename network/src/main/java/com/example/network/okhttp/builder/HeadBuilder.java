package com.example.network.okhttp.builder;


import com.example.network.okhttp.OkHttpUtils;
import com.example.network.okhttp.request.OtherRequest;
import com.example.network.okhttp.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder {
    @Override
    public RequestCall build() {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers, id).build();
    }
}
