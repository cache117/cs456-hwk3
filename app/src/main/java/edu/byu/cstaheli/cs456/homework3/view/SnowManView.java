package edu.byu.cstaheli.cs456.homework3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by cstaheli on 1/31/2017.
 */

public class SnowManView extends View
{
    private static final String TAG = "SnowManView";
    private Paint snowManPaint, buttonPaint, eyePaint;
    private float xOffset, yOffset;

    public SnowManView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.init();
    }

    private void init()
    {
        snowManPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        snowManPaint.setStyle(Paint.Style.STROKE);
        snowManPaint.setColor(Color.BLACK);

        buttonPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        buttonPaint.setStyle(Paint.Style.FILL);
        buttonPaint.setColor(0xFF8B4513);
//        buttonPaint.setColor(Color.CYAN);

        eyePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        eyePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        eyePaint.setColor(0xF1800000);

        xOffset = 0;
        yOffset = 0;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        drawHead(canvas);
        drawBody(canvas);
    }

    private float getCenterX()
    {
        return (getWidth() / 2) + xOffset;
    }

    private float getCenterY()
    {
        return (getHeight() / 2) + yOffset;
    }

    private void drawHead(Canvas canvas)
    {
        float headY = getCenterY() - (getHeight() / 4);
        float radius = getWidth() / 6;
        drawCircle(canvas, getCenterX(), headY, radius, snowManPaint);
        drawFace(canvas, headY, radius);
    }

    private void drawFace(Canvas canvas, float headYCenter, float headRadius)
    {
        float eyeRadius = headRadius / 10;
        float cy = headYCenter - (getHeight() / 25);
        float leftX = getCenterX() - (getWidth() / 20);
        float rightX = getCenterX() + (getWidth() / 20);
        drawCircle(canvas, leftX, cy, eyeRadius, eyePaint);
        drawCircle(canvas, rightX, cy, eyeRadius, eyePaint);
    }

    private void drawBody(Canvas canvas)
    {
        float bodyY = getCenterY() - getHeight() / 16;
        float radius = getWidth() / 4;
        drawCircle(canvas, getCenterX(), bodyY, radius, snowManPaint);
        drawButtons(canvas, bodyY, radius);

        bodyY += getHeight() / 3.5;
        radius = getWidth() / 3;
        drawCircle(canvas, getCenterX(), bodyY, radius, snowManPaint);
        drawButtons(canvas, bodyY, radius);
    }

    private void drawButtons(Canvas canvas, float bodyYCenter, float bodyRadius)
    {
        float buttonY = bodyYCenter;
        float buttonRadius = bodyRadius / 8;
        float buttonSpacing = buttonRadius * 3;
        drawCircle(canvas, getCenterX(), buttonY, buttonRadius, buttonPaint);

        buttonY = bodyYCenter + buttonSpacing;
        drawCircle(canvas, getCenterX(), buttonY, buttonRadius, buttonPaint);

        buttonY = bodyYCenter - buttonSpacing;
        drawCircle(canvas, getCenterX(), buttonY, buttonRadius, buttonPaint);
    }

    private void drawCircle(Canvas canvas, float cx, float cy, float radius, Paint paint)
    {
        canvas.drawCircle(cx, cy, radius, paint);
        Log.d(TAG, String.format("Creating Circle: (%s, %s) r = %s", cx, cy, radius));
    }


}
