package com.imperial.huefinder;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CropImageFragment extends Fragment {

    private CropImageView cropImage;
    public static TextView textView;

    public static CropImageFragment newInstance() {
        return new CropImageFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_crop, container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Activity activity = getActivity();
        cropImage = (CropImageView) activity.findViewById(R.id.cropImage);
        textView = (TextView) activity.findViewById(R.id.crop);
        cropImage.setImageURI(Uri.parse(ImageActivity.file));
        cropImage.setTextView(textView);
    }

    public void setText(String text) {
        textView.setText(text);
    }
}
