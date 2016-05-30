package com.example.yanli.android_event_practise;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;


/**
 * Created by binbin on 5/24/2016.
 */
public class PlaneView extends View {
    public float currentX;
    public float currentY;
    Bitmap plane;

    public PlaneView(Context context){
        super(context);
        plane = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
        setFocusable(true);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawBitmap(plane,currentX, currentY,p);
    }
}
