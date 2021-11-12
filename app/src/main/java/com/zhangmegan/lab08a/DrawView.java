package com.zhangmegan.lab08a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    Paint red = new Paint();
    Paint gold = new Paint();
    Paint curve = new Paint();
    Paint star = new Paint();
    Paint street = new Paint();
    int linex = 0;
    int liney = 600;
    int ovalWidth = 160;
    int y = 600;
    float rad = 28;
    int alpha = 70;
    double dY = 0.5, dR = 0.2;
    int x = 0, dX = 3, dA = 2;
    float[][] snow = new float[100][100];

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //start
        star.setColor(Color.WHITE);
        canvas.drawCircle(x, y, 4, star);

        // street
        Path myPath = new Path();
        myPath.moveTo(0,getHeight());
        myPath.lineTo(400, getHeight()-1000);
        myPath.lineTo(getWidth()-400, getHeight()-1000);
        myPath.lineTo(getWidth(), getHeight());

        street.setColor(Color.parseColor("#9c9491"));
        canvas.drawPath(myPath, street);

        // walls
        Paint building = new Paint();
        building.setColor(Color.parseColor("#9c5240"));
        myPath.reset();
        myPath.moveTo(0, getHeight());
        myPath.lineTo(0, 0);
        myPath.lineTo(400, 0);
        myPath.lineTo(400, getHeight()-1000);
        canvas.drawPath(myPath, building);

        myPath.reset();
        myPath.moveTo(getWidth(), getHeight());
        myPath.lineTo(getWidth(), 0);
        myPath.lineTo(getWidth()-400, 0);
        myPath.lineTo(getWidth()-400, getHeight()-1000);
        canvas.drawPath(myPath, building);

        // door
//        myPath.reset();
//        myPath.moveTo(100, getHeight()-270);
//        myPath.lineTo(100, getHeight()-800);
//        myPath.lineTo(240, getHeight()-1050);
//        myPath.lineTo(240, getHeight()-650);
//        canvas.drawPath(myPath, new Paint());

        red.setColor(Color.parseColor("#f24e30"));
        gold.setColor(Color.parseColor("#ffc929"));
        curve.setStyle(Paint.Style.STROKE);
        curve.setStrokeWidth(8);
        canvas.drawArc(0, liney, getWidth(), liney+100, 0, 175,
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
        Rect r5 = new Rect(920, 795,995,830);
        canvas.drawRect(r, gold);
        canvas.drawRect(r2, gold);
        canvas.drawRect(r3, gold);
        canvas.drawRect(r4, gold);
        canvas.drawRect(r5, gold);

        Paint light = new Paint();
        light.setColor(Color.parseColor("#ffdd00"));
        light.setAlpha(alpha);
        canvas.drawCircle(95, liney+170, rad, light);
        canvas.drawCircle(310, liney+187, rad, light);
        canvas.drawCircle(525,liney+189, rad, light);
        canvas.drawCircle(740, liney+187, rad, light);
        canvas.drawCircle(955, liney+170, rad, light);

        for(int i = 0; i < snow.length; i++)

        y-= dY;
        x+= dX;
        if(rad < 28 || rad >= 32)
            dR = -dR;
        rad += dR;
        if(alpha < 70 || alpha >= 110)
            dA = -dA;
        alpha += dA;
        invalidate();

    }

}
