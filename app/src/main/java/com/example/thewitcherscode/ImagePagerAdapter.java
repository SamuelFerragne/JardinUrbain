package com.example.thewitcherscode;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class ImagePagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private List<Integer> images;

    public ImagePagerAdapter(Context context, FragmentManager fm, List<Integer> images) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ImageFragment fragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("imageResource", images.get(position));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return images.size();
    }
}
