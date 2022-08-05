package com.example.socially.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.socially.R;

public class ViewPagerAdapter extends PagerAdapter{

    Context context;

    int[] images = {
            R.drawable.image_sp1,
            R.drawable.image_sp2,
            R.drawable.image_sp2
    };

    int[] titletop = {

            R.string.title,
            R.string.title,
            R.string.title
    };

    int[] appname = {

            R.string.appname,
            R.string.appname,
            R.string.appname

    };

    public ViewPagerAdapter(Context context){

        this.context = context;

    }

    @Override
    public int getCount() {
        return titletop.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView imageViewMiddle=view.findViewById(R.id.imageViewMiddle);
        TextView textViewTitleTop=view.findViewById(R.id.textViewTitleTop);
        TextView textViewAppName=view.findViewById(R.id.textViewAppName);

        imageViewMiddle.setImageResource(images[position]);
        textViewTitleTop.setText(titletop[position]);
        textViewAppName.setText(appname[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);

    }
}
