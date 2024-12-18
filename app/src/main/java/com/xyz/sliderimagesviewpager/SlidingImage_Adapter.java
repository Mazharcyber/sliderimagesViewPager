package com.xyzz.sliderimagesviewpager;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class SlidingImage_Adapter extends PagerAdapter {

    private ArrayList<ImageModel> imageModelLsit;
    private LayoutInflater inflater;
    private Context context;

    public SlidingImage_Adapter(ArrayList<ImageModel> imageModelLsit, Context context) {
        this.imageModelLsit = imageModelLsit;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return imageModelLsit.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View imageLayout = inflater.inflate(R.layout.slidingimages,container,false);
        assert  imageLayout != null;

        final ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);
        container.addView(imageLayout,0);
        imageView.setImageResource(imageModelLsit.get(position).getImage_drawable());
        
        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {

    }

    @Nullable
    @Override
    public Parcelable saveState() {
        return null;
    }
}
