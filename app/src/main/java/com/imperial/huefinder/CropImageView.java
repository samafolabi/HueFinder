package com.imperial.huefinder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by emper on 12/06/2018.
 */

public class CropImageView extends AppCompatImageView {

    private TextView textView;

    public CropImageView(Context context) {
        super(context);
    }

    public CropImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Bitmap bmp = ((BitmapDrawable) getDrawable()).getBitmap();
        int x = Math.round(event.getX()), y = Math.round(event.getY());
        int intColor = bmp.getPixel(x, y);
        String text = String.format("#%06X", (0xFFFFFF & intColor));
        CropImageFragment.textView.setText(text);

        postInvalidate();
        return true;
    }
}
