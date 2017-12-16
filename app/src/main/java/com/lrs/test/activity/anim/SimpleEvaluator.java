package com.lrs.test.activity.anim;

import android.animation.TypeEvaluator;

import com.example.util.utils.LogUtil;

/**
 * Created by 廖荣森 on 2017/12/16.
 */

public class SimpleEvaluator implements TypeEvaluator<SimpleTypeValue> {


    @Override
    public SimpleTypeValue evaluate(float fraction, SimpleTypeValue startValue, SimpleTypeValue endValue) {
        LogUtil.e("evaluate--" + "fracyion=" + fraction);
        SimpleTypeValue s = new SimpleTypeValue();
        s.x = 100;
        s.y = 100;
        return s;
    }


}
