package com.lrs.test.activity.splash;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.network.okhttp.OkHttpUtils;
import com.example.network.okhttp.callback.BitmapCallback;
import com.example.util.utils.ToastUtil;
import com.lrs.test.R;
import com.squareup.okhttp.Request;

import okhttp3.Call;


public class SplashActivity extends AppCompatActivity {


    private Button button;
    private ImageView imageView;

    private String url = "http://f.hiphotos.baidu.com/image/pic/item/7e3e6709c93d70cfa63d873bf2dcd100bba12bc4.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.imageview);
        button = findViewById(R.id.button);
        OkHttpUtils.get()//
                .url(url)//
                .build()//
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.show(getApplication(), e.getMessage() + "id=" + id);
                    }

                    @Override
                    public void onResponse(Bitmap response, int id) {
                        imageView.setImageBitmap(response);
                        ToastUtil.show(getApplication(), "id==" + id);
                    }
                });
    }


}
