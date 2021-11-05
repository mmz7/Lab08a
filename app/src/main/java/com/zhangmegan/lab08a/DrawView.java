package com.zhangmegan.lab08a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    Paint red = new Paint();
    Paint gold = new Paint();
    Paint curve = new Paint();
    int linex = 0;
    int liney = 600;
    int ovalWidth = 160;

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        red.setColor(Color.parseColor("#f24e30"));
        gold.setColor(Color.parseColor("#ffc929"));
        curve.setStyle(Paint.Style.STROKE);
        curve.setStrokeWidth(8);
        canvas.drawArc(0, liney, 1100, liney+100, 0, 175,
                false, curve);
        canvas.drawOval(15, liney+85,175,liney+200,red);
        canvas.drawOval(230, liney+102,230+ovalWidth,
                liney+217,red);
        canvas.drawOval(445, liney+104,445+ovalWidth,
                liney+219,red);
        canvas.drawOval(660, liney+102,660+ovalWidth,
                liney+217,red);
        canvas.drawOval(875, liney+87,875+ovalWidth,
                liney+202,red);
        Rect r = new Rect(60,795, 135, 830);
        Rect r2 = new Rect(275,812, 350, 847);
        Rect r3 = new Rect(490,814, 565, 849);
        Rect r4 = new Rect(705,812, 780, 847);
        canvas.drawRect(r, gold);
        canvas.drawRect(r2, gold);
        canvas.drawRect(r3, gold);
    }
}
