package com.imperial.huefinder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by emper on 06/07/2018.
 */

public class ColorSelectImageView extends AppCompatImageView {

    private TextView textView;

    public ColorSelectImageView(Context context) {
        super(context);
    }

    public ColorSelectImageView(Context context, @Nullable AttributeSet attrs) {
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
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();

        postInvalidate();
        return true;
    }
}

