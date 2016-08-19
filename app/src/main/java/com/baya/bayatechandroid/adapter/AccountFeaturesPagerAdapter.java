package com.baya.bayatechandroid.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baya.bayatechandroid.R;
import com.baya.bayatechandroid.model.FeaturePagesEnum;

/**
 * Copyright (c) 2016 BayaTech. All rights reserved.
 */
public class AccountFeaturesPagerAdapter extends PagerAdapter {

    private Context mContext;

    public AccountFeaturesPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return FeaturePagesEnum.values().length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.account_oauth_pager_view, container, false);
        initViews(view, position);
        container.addView(view);
        return view;
    }

    private void initViews(View view, int pos) {
        TextView textView = (TextView) view.findViewById(R.id.feature_image_title);
        textView.setText(mContext.getString(FeaturePagesEnum.values()[pos].getTextId()));

        ImageView imageView = (ImageView) view.findViewById(R.id.feature_image);
        imageView.setBackgroundResource(FeaturePagesEnum.values()[pos].getImageId());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
