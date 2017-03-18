package com.lautaro.dotviewclock;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;

/**
 * Created by Gustavo Realpe on 15/03/2017.
 */

public class DrawView extends View {
    Paint paint = new Paint();
    Display display;

    public DrawView(Context context) {
        super(context);
        display = ((Activity) context).getWindowManager().getDefaultDisplay();
        paint.setColor(Color.WHITE);
        //paint.setStyle(Paint.Style.STROKE);
        // // Line width in pixels
        //paint.setStrokeWidth(15);
        //paint.setAntiAlias(true);
    }

    @Override
    public void onDraw(Canvas canvas) {

        Point size = new Point();
        display.getRealSize(size);
        int width = size.x;
        int height = size.y;
        float step = ((float)width) / 25F;
        float stepy = ((float)height) / 44F;
        float radio = 2.5F;

        Log.i("tavo", String.valueOf(width));
        Log.i("tavo", String.valueOf(height));
        for (float y = radio*3; y < height; y += stepy) {
            for (float x = radio; x < width; x += step) {
                canvas.drawCircle(x, y, radio, paint);
            }
        }
    }

}