package com.lrs.viewandutil.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lrs.viewandutil.util.LogUtil;

/**
 * Created by wb-lrs192703 on 2017/6/16.
 */

public class FlowLayout extends LinearLayout implements View.OnClickListener {


    public static final String TAG = "FlowLayout";

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {


    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int totalW = 0, totalH = 0;
        int mostH = 0;//当行最大高度；
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            ViewGroup.MarginLayoutParams p = (MarginLayoutParams) child.getLayoutParams();
            if (mostH < getChildMarginHeight(p, child)) {
                mostH = getChildMarginHeight(p, child);
            }
            LogUtil.e(getClass(), "totalW=" + totalW + "totalH=" + totalH);
            if (totalW + getChildMarginWidth(p, child) >= getMeasuredWidth()) {//当行显示将要超过时；
                totalW = 0;
                totalH += mostH;
                mostH = 0;
            }
            totalW += getChildMarginWidth(p, child);
        }
        totalH += mostH;

        setMeasuredDimension(getMeasuredWidth(), totalH);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        int totalW = 0, totalH = 0;
        int mostH = 0;//当行最大高度；
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            int measuredHeight = child.getMeasuredHeight();
            int measuredWidth = child.getMeasuredWidth();
            ViewGroup.MarginLayoutParams p = (MarginLayoutParams) child.getLayoutParams();
            if (mostH < getChildMarginHeight(p, child)) {
                mostH = getChildMarginHeight(p, child);
            }
            if (totalW + getChildMarginWidth(p, child) >= getMeasuredWidth()) {//当行显示将要超过时；
                totalW = 0;
                totalH += mostH;
                mostH = 0;
            }
            child.layout(totalW + p.leftMargin, totalH + p.topMargin, totalW + p.leftMargin
                    + measuredWidth, totalH + p.topMargin + measuredHeight);

            totalW += getChildMarginWidth(p, child);
        }


    }


    private int getChildMarginWidth(ViewGroup.MarginLayoutParams p, View child) {
        return p.leftMargin + p.rightMargin + child.getMeasuredWidth();
    }

    private int getChildMarginHeight(ViewGroup.MarginLayoutParams p, View child) {
        return p.topMargin + p.bottomMargin + child.getMeasuredHeight();
    }

    @Override
    public void onClick(View v) {

    }


}
