package com.zhangmegan.lab08a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Snow {
    Canvas canvas;
    float centerx, centery, radius;
    public Snow(float cx, float cy, float r, Canvas c) {
        canvas = c;
        centerx = cx;
        centery = cy;
        radius = r;
    }

    public void drawSnow(Paint paint) {
        canvas.drawCircle(centerx, centery, radius, paint);
    }

}
