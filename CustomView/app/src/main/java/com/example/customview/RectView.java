package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;

public class RectView extends View {

    public static final String TAG = "RectView";

    private final Paint paint = new Paint();

    public RectView(Context context) {
        super(context);
        init();
    }

    private void init() {
        int color = Color.RED;
        paint.setColor(color);
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr,
            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure");
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST) {
            widthSize = 700;
        }
        if (heightMode == MeasureSpec.AT_MOST) {
            heightSize = 100;
        }

        setMeasuredDimension(widthSize, heightSize);
    }

    @Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "onLayout");
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw");

        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        int width = getWidth();
        int height = getHeight();

        int left = paddingStart;
        int top = paddingTop;
        int right = width - paddingTop;
        int bottom = height - paddingBottom;

        Log.d(TAG, "paddingStart = " + paddingStart
                + " paddingEnd = " + paddingEnd
                + " paddingTop = " + paddingTop
                + " paddingBottom = " + paddingBottom
                + " width = " + width
                + " height = " + height
                + " left = " + left
                + " top = " + top
                + " right = " + right
                + " bottom = " + bottom);

        canvas.drawRect(left, top, right, bottom, paint);
    }
}
