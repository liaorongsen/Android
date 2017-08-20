package com.lrs.viewandutil.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.lrs.viewandutil.R;
import com.lrs.viewandutil.util.LogUtil;

/**
 * Created by wb-lrs192703 on 2017/6/15.
 */

public class TranslucenceTextView extends android.support.v7.widget.AppCompatTextView {
    private static final String TAG = "TranslucenceTextView";

    public TranslucenceTextView(Context context) {
        this(context, null);
    }

    public TranslucenceTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TranslucenceTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TranslucenceTextView, defStyleAttr, 0);
        float conner = a.getDimension(R.styleable.TranslucenceTextView_BackGroundConnerRadious, 5);
        a.recycle();
        setBackgroundResource(R.drawable.shape_textview_bg);
    }


}
