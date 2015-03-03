package com.jacob.measure;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/**
 * Package : com.jacob.measure
 * Author : jacob
 * Date : 15-3-3
 * Description : 这个类是用来xxx
 */
public class WeightDashBoard extends View {
    private int mWeight = 50;

    private Bitmap mBitmapDash;
    private Bitmap mBitmapIndicator;
    private Paint mTextPaint;
    private Paint mBitmapPaint;

    private int mTextSize = dpToPx(20);
    private int mTextColor = 0xffff4546;
    private String mText;
    private int mTextWidth;
    private int mTextHeight;

    public WeightDashBoard(Context context) {
        this(context, null);
    }

    public WeightDashBoard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeightDashBoard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setColor(mTextColor);

        mBitmapPaint = new Paint();
        mBitmapPaint.setAntiAlias(true);

        mText = String.valueOf(mWeight) + "KG";
        mTextWidth = (int) mTextPaint.measureText(mText, 0, mText.length());
        Rect rect = new Rect();
        mTextPaint.getTextBounds(mText, 0, mText.length(), rect);
        mTextHeight = rect.height();

        mBitmapDash = BitmapFactory.decodeResource(getResources(), R.mipmap.s_weight_rule);
        mBitmapIndicator = BitmapFactory.decodeResource(getResources(), R.mipmap.s_w_hand);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(mBitmapDash.getWidth(), mBitmapDash.getHeight());
    }


    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        Rect rectD = new Rect(0, 0, mBitmapDash.getWidth(), mBitmapDash.getHeight());
        canvas.drawBitmap(mBitmapDash, null, rectD, mBitmapPaint);
        canvas.drawBitmap(mBitmapIndicator, null, rectD, mBitmapPaint);
        canvas.drawText(mText, mBitmapDash.getWidth() / 2 - mTextWidth / 2, mBitmapDash.getHeight() / 2 + mTextHeight / 2, mTextPaint);
    }

    private int dpToPx(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
