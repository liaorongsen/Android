package com.lrs.test.activity.splash;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.util.utils.ToastUtil;
import com.lrs.test.R;
import com.lrs.test.activity.base.BaseActivity;

public class SplashActivity extends BaseActivity {


    private Button button;
    private ImageView imageView;
    private static final int TIME = 3000;//30秒倒计时；

    private TextView countDownText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        findViewById(R.id.parent).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                ToastUtil.show(getApplication(), "Parent-onLongClick");
                return false;
            }
        });


        findViewById(R.id.child).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show(getApplication(), "Child-click");
            }
        });

    }


}
