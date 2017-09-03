package com.lrs.viewandutil.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.lrs.viewandutil.util.LogUtil;

/**
 * Created by 廖荣森 on 2017/8/20.
 */

public class MView extends View {


    public MView(Context context) {
        this(context, null);
    }

    public MView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.e(getClass(), "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.e(getClass(), "onTouchEvent");
        return super.onTouchEvent(event);
    }


    @Override
    protected void dispatchDraw(Canvas canvas) {
        LogUtil.e(getClass(), "dispatchDraw");
        super.dispatchDraw(canvas);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        LogUtil.e(getClass(), "onMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        LogUtil.e(getClass(), "onLayout");
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        LogUtil.e(getClass(), "onDraw");
        super.onDraw(canvas);
    }
}
