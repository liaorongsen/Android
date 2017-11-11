package com.lrs.test.activity.splash;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.network.okhttp.OkHttpUtils;
import com.example.network.okhttp.callback.BitmapCallback;
import com.example.util.utils.ToastUtil;
import com.lrs.test.R;
import com.lrs.test.activity.base.BaseActivity;
import com.lrs.test.activity.main.MainActivity;
import com.squareup.okhttp.Request;

import okhttp3.Call;


public class SplashActivity extends BaseActivity {


    private Button button;
    private ImageView imageView;
    private static final int TIME = 30000;//30秒倒计时；

    private TextView countDownText;

    private CountDownTask countDownTask;

    private String url = "http://f.hiphotos.baidu.com/image/pic/item/7e3e6709c93d70cfa63d873bf2dcd100bba12bc4.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (countDownTask == null) {
            countDownTask = new CountDownTask(TIME, 1000);
        }
        imageView = findViewById(R.id.imageview);
        countDownText = findViewById(R.id.count_down);
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

        countDownTask.start();
    }

    private class CountDownTask extends CountDownTimer {

        public CountDownTask(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            long second = millisUntilFinished / 1000;

            countDownText.setText(second + "s");
            ToastUtil.show(getApplication(), millisUntilFinished + "");


        }

        @Override
        public void onFinish() {

            navMain();
        }
    }


    private void navMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
