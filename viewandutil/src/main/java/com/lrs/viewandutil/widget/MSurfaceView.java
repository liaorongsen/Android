package com.lrs.viewandutil.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.lrs.viewandutil.R;
import com.lrs.viewandutil.util.LogUtil;

/**
 * Created by 廖荣森 on 2017/10/24.
 */

public class MSurfaceView extends SurfaceView implements SurfaceHolder.Callback {


    private SurfaceHolder surfaceHolder;
    private float centerX, centerY;
    private Paint paint;

    public MSurfaceView(Context context) {
        this(context, null);
    }

    public MSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
       paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(10);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        centerX = displayMetrics.widthPixels / 2;
        centerY = displayMetrics.heightPixels / 2;

    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        LogUtil.e("surfaceCreated+" + surfaceHolder);
        draw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        LogUtil.e("surfaceCreated" + surfaceHolder + "i=" + i + "--i1=" + i1 + "--i2=" + i2);

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        LogUtil.e("surfaceDestroyed" + surfaceHolder);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
     //   drawUI(canvas, paint);
    }

    public void draw() {
        DrawTask t = new DrawTask();
        Thread thread = new Thread(t);
        thread.start();

    }

    private void drawUI(Canvas canvas, Paint paint) {
        canvas.drawCircle(centerX, centerY, 100, paint);


        // canvas.drawPath(path, paint);

    }

    public class DrawTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                Canvas canvas =
                        surfaceHolder.lockCanvas();
                drawUI(canvas, paint);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }


}
