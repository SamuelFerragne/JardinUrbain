package com.example.thewitcherscode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

public class ImageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        // Retrieve the image resource from the arguments
        Bundle bundle = getArguments();
        if (bundle != null) {
            int imageResource = bundle.getInt("imageResource", 0);

            // Display the image using Glide (add the dependency if needed)
            Glide.with(this)
                    .load(imageResource)
                    .apply(RequestOptions.centerInsideTransform())
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into((ImageView) view.findViewById(R.id.imageView));
        }

        return view;
    }
}
