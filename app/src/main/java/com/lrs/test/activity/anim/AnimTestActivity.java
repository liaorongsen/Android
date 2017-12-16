package com.lrs.test.activity.anim;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.util.utils.LogUtil;
import com.lrs.test.R;
import com.lrs.test.activity.base.BaseActivity;

public class AnimTestActivity extends BaseActivity {


    private TextView mTraget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_test);
        mTraget = findViewById(R.id.target);

        startAanim(mTraget);
    }

    private void startAanim(View target) {

        ValueAnimator valueAnimator = ValueAnimator.ofObject(new SimpleEvaluator(), new SimpleTypeValue(1, 1), new SimpleTypeValue(1, 1))
                .setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                SimpleTypeValue animatedValue = (SimpleTypeValue) animation.getAnimatedValue();

                LogUtil.e("animValue=" + animatedValue.toString());
            }
        });

        valueAnimator.start();


    }


}
