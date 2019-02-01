package com.imperial.huefinder;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Collections;

/**
 * Created by emper on 12/06/2018.
 */

public class CanvasImageFragment1 extends Fragment {

    private CanvasImageView canvas;
    private Button cropButton;
    public static Bitmap bitmap = null;

    public static CanvasImageFragment1 newInstance() {
        return new CanvasImageFragment1();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_canvas, container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Activity activity = getActivity();
        cropButton = (Button) activity.findViewById(R.id.crop);
        cropButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int xMin = Math.round(Collections.min(canvas.xPoints));
                int yMin = Math.round(Collections.min(canvas.yPoints));
                int xMax = Math.round(Collections.max(canvas.xPoints));
                int yMax = Math.round(Collections.max(canvas.yPoints));
                Bitmap bmp = BitmapFactory.decodeFile(ImageActivity.file);
                bitmap = Bitmap.createBitmap(bmp, xMin, yMin, xMax-xMin, yMax-yMin);

                Fragment fragment = new CropImageFragment();
                FragmentTransaction tran = getFragmentManager().beginTransaction();
                tran.replace(R.id.imageContainer, fragment);
                tran.addToBackStack(null);
                tran.commit();
            }
        });

        try {
            canvas = (CanvasImageView) activity.findViewById(R.id.canvas);
            Intent intent = activity.getIntent();
            ImageActivity.file = intent.getStringExtra(CameraActivity.globalFile);
            canvas.setImageURI(Uri.parse(ImageActivity.file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
