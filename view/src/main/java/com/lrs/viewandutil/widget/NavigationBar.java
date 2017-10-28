package com.lrs.viewandutil.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.lrs.viewandutil.R;
import com.lrs.viewandutil.util.MathUtil;


/**
 * Created by wb-lrs192703 on 2017/6/20.
 */

public class NavigationBar extends View {

    private int mTabCount = 0;
    private float itemHeight = -1;
    private Paint paint;
    private Paint.FontMetricsInt mFontMetricsInt;

    private float orignY = 0f;//参考原点；默认为view的左上角；

    private Mode mMode = Mode.SMALL;

    private float mExpandH;

    public NavigationBar(Context context) {
        this(context, null);
    }

    public NavigationBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (paint == null) {
            paint = new Paint();
            paint.setTextSize(MathUtil.dp2px(getContext(), itemHeight ));
            paint.setColor(Color.WHITE);
            paint.setFlags(Paint.ANTI_ALIAS_FLAG);
            mFontMetricsInt = paint.getFontMetricsInt();
        }
        setBackgroundResource(R.drawable.shape_circle_tran);
    }

    public void setMode(Mode mMode) {
        this.mMode = mMode;
        if (mMode == Mode.SMALL) {
            orignY = 0;
        }
        invalidate();
    }

    private boolean mCaluate;

    public void setmExpandH(float expandH) {
        if (!mCaluate && expandH > 0) {
            this.mExpandH = expandH;
            mCaluate = true;
            invalidate();
        }
    }

    public float getExpandH() {
        return mExpandH;
    }

    enum Mode {
        SMALL,
        LARGE
    }

    public void onScroll(float xOffSet, float yOffSet) {
        if (mMode == Mode.LARGE) {
            orignY = -yOffSet;
            invalidate();
        }
    }

    public void setTabCount(int mTabCount) {
        this.mTabCount = mTabCount;
        invalidate();
    }

    private float mW;
    private float mH;

    private float getMinWidth() {
        for (int i = 0; i < mTabCount; i++) {
            String text = i + "";
            float v = paint.measureText(text);
            if (mW < v) {
                mW = v;
            }
        }
        return mW;
    }

    private float getMinHeight() {
        for (int i = 0; i < mTabCount; i++) {
            String text = i + "";
            float v = paint.measureText(text);
            if (mW < v) {
                mW = v;
            }
        }
        return mW;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mTabCount <= 0)
            return;
        if (mMode == Mode.SMALL) {
            performDrawSmall(canvas);
        } else if (mMode == Mode.LARGE) {
            performDrawLarge(canvas);
        }

    }

    private void performDrawLarge(Canvas canvas) {
        itemHeight = mExpandH / mTabCount;
        float widthCenter = getMeasuredWidth() / 2.0f;
        float y = (itemHeight - mFontMetricsInt.ascent - mFontMetricsInt.descent) / 2;
        for (int i = 0; i < mTabCount; i++) {
            String text = i + 1 + "";
            canvas.drawText(text, widthCenter - paint.measureText(text) / 2, orignY + itemHeight * i + y, paint);
        }

    }

    private void performDrawSmall(Canvas canvas) {

        itemHeight = getHeight() / mTabCount;
        float widthCenter = getMeasuredWidth() / 2.0f;
        float y = (itemHeight - mFontMetricsInt.ascent - mFontMetricsInt.descent) / 2;
        for (int i = 0; i < mTabCount; i++) {
            String text = i + 1 + "";
            canvas.drawText(text, widthCenter - paint.measureText(text) / 2, orignY + itemHeight * i + y, paint);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
