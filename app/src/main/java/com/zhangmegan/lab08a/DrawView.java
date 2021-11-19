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

import java.util.ArrayList;
import java.util.List;

public class DrawView extends View {
    Paint red = new Paint();
    Paint gold = new Paint();
    Paint curve = new Paint();
    Paint star = new Paint();
    Paint street = new Paint();
    Paint prints = new Paint();
    int linex = 0;
    int liney = 600;
    int ovalWidth = 160;
    float rad = 28;
    int alpha = 70;
    double dR = 0.2;
    int dA = 2;
    float sX, sY = 0;
    ArrayList<ArrayList<Float>> snowArr;

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        snowArr = new ArrayList<ArrayList<Float>>();
        for(int i = 0; i < 450; i++) {
            ArrayList<Float> dim = new ArrayList<Float>();
            float x = (float) (Math.random() * (1081));
            float y = (float) (Math.random() * (1869));
            float dX = (float)(Math.random()*1.5+1.5);
            float dY = (float)(Math.random()*2+4);
            dim.add(x);
            dim.add(y);
            dim.add((float)0);
            dim.add((float) 0);
            dim.add(dX);
            dim.add(dY);
            snowArr.add(dim);
        }
        System.out.println(getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // street
        Path myPath = new Path();
        myPath.moveTo(0,getHeight());
        myPath.lineTo(460, getHeight()-1300);
        myPath.lineTo(getWidth()-460, getHeight()-1300);
        myPath.lineTo(getWidth(), getHeight());

        street.setColor(Color.parseColor("#9c9491"));
        canvas.drawPath(myPath, street);

        // walls
        Paint building = new Paint();
        building.setColor(Color.parseColor("#9c5240"));
        myPath.reset();
        myPath.moveTo(0, getHeight());
        myPath.lineTo(0, 0);
        myPath.lineTo(460, 0);
        myPath.lineTo(460, getHeight()-1300);
        canvas.drawPath(myPath, building);

        myPath.reset();
        myPath.moveTo(getWidth(), getHeight());
        myPath.lineTo(getWidth(), 0);
        myPath.lineTo(getWidth()-460, 0);
        myPath.lineTo(getWidth()-460, getHeight()-1300);
        canvas.drawPath(myPath, building);

        myPath.reset();
        myPath.moveTo(40, 600);
        myPath.lineTo(130, 690);
        myPath.lineTo(220, 600);
        myPath.lineTo(130, 510);
        canvas.drawPath(myPath, new Paint());

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

        Paint snow = new Paint();
        snow.setColor(Color.WHITE);
        snow.setAlpha(130);

        for(int i = 0; i < snowArr.size(); i++) {
            ArrayList<Float> dim = snowArr.get(i);
            Snow s = new Snow(dim.get(0)+dim.get(2), dim.get(1)+dim.get(3), canvas);
            s.drawSnow(snow, 6);
            dim.set(2, dim.get(2)+dim.get(4));
            dim.set(3, dim.get(3)+dim.get(5));
            if(dim.get(0)+dim.get(2) > getWidth()) {
                dim.set(2, (float)0);
                dim.set(0, (float)0);
            }
            if(dim.get(1)+dim.get(3) > getHeight()) {
                dim.set(3, (float)0);
                dim.set(1, (float)0);
            }
        }

        if(rad < 28 || rad >= 32)
            dR = -dR;
        rad += dR;
        if(alpha < 70 || alpha >= 110)
            dA = -dA;
        alpha += dA;
        invalidate();

    }

}
