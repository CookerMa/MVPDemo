package com.mj.mvpdemo.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者：Nick on 2016/5/10 14:14
 * 邮箱：mj0120@foxmail.com
 */


public class MyProgressView extends View {

    private int mFirstColor = Color.RED;
    private int mSecondColor =Color.BLUE;
    private int mCircleWidth =100;
    private Paint mPaint;
    private int mProgress;
    private int mSpeed =5;

    /**
     * 是否应该开始下一个
     */
    private boolean isNext = false;

    public MyProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int center =getWidth()/2;
        int radius=center-mCircleWidth/2;

        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(mCircleWidth);
        mPaint.setStyle(Paint.Style.STROKE); //空心
//        mPaint.setStrokeCap(Paint.Cap.ROUND); //空心
        RectF oval = new RectF(center - radius, center - radius, center + radius, center + radius);
        if (!isNext)
        {// 第一颜色的圈完整，第二颜色跑
            mPaint.setColor(mFirstColor); // 设置圆环的颜色
            canvas.drawCircle(center, center, radius, mPaint); // 画出圆环
            mPaint.setColor(mSecondColor); // 设置圆环的颜色
            canvas.drawArc(oval, -90, mProgress, false, mPaint); // 根据进度画圆弧
        } else
        {
            mPaint.setColor(mSecondColor); // 设置圆环的颜色
            canvas.drawCircle(center, center, radius, mPaint); // 画出圆环
            mPaint.setColor(mFirstColor); // 设置圆环的颜色
            canvas.drawArc(oval, -90, mProgress, false, mPaint); // 根据进度画圆弧
        }

    }

    private void init() {
        mPaint = new Paint();
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    mProgress++;
                    if (mProgress == 360) {
                        mProgress = 0; //重置
                        isNext = !isNext;
                    }
                  postInvalidate();

                    try {
                        Thread.sleep(mSpeed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }


}
