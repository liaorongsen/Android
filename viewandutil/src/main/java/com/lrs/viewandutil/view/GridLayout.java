package com.lrs.viewandutil.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.lrs.viewandutil.R;

/**
 * Created by wb-lrs192703 on 2017/6/16.
 */

public class GridLayout extends RelativeLayout {

    private int mVerticalPadding = 10;
    private int mHorizontialPadding = 10;
    private int mLineNum;
    private int mRowNum;

    public GridLayout(Context context) {
        this(context, null);
    }

    public GridLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GridLayout);
        mLineNum = a.getInteger(R.styleable.GridLayout_lineNum, 3);//行数
        mRowNum = a.getInteger(R.styleable.GridLayout_rowNum, 2);//列数
        a.recycle();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int w = getMeasuredWidth();
        int h = getMeasuredHeight();
        int childW = (w - mHorizontialPadding * (mRowNum + 1)) / mRowNum;
        int childH = (h - mVerticalPadding * (mLineNum + 1)) / mLineNum;

        RelativeLayout.MarginLayoutParams lp = new RelativeLayout.LayoutParams(childW, childH);
        for (int i = 0; i < getChildCount(); i++) {
            int xOff, yOff;
            View child = getChildAt(i);
            xOff = (i + 1) % mLineNum;
            yOff = (i + 1) % mRowNum;
            child.setLayoutParams(lp);
            int left = (mHorizontialPadding + childW) * (xOff - 1) + mHorizontialPadding;
            int top = (mVerticalPadding + childH) * (yOff - 1) + mVerticalPadding;
            int right = left + childW;
            int botom = top + childH;
            child.layout(left, top, right, botom);
        }

    }
}
