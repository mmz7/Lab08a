package com.zhangmegan.lab08a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Snow {
    Canvas canvas;
    float centerx, centery, dX, dY, radius;
    public Snow(float cx, float cy, Canvas c) {
        canvas = c;
        centerx = cx;
        centery = cy;
    }

    public void drawSnow(Paint paint, float radius) {
        canvas.drawCircle(centerx, centery, radius, paint);
    }

}
