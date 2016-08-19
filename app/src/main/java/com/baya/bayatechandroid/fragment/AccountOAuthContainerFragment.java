package com.baya.bayatechandroid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baya.bayatechandroid.R;
import com.baya.bayatechandroid.activity.AccountActivity;
import com.baya.bayatechandroid.adapter.AccountFeaturesPagerAdapter;
import com.baya.bayatechandroid.model.FeaturePagesEnum;
import com.baya.bayatechandroid.views.MainViewPager;


/**
 * Copyright (c) 2016 BayaTech. All rights reserved.
 */
public class AccountOAuthContainerFragment extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ImageView[] mBullet = new ImageView[FeaturePagesEnum.values().length];

    public AccountOAuthContainerFragment() {
        // Recommended empty Constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_oauth_container, container, false);
        initViews(view);
        return view;
    }

    public void initViews(View view) {
        TextView textView = (TextView) view.findViewById(R.id.login_text_view);
        textView.setOnClickListener(this);

        mBullet[0] = (ImageView) view.findViewById(R.id.feature_bullet_1);
        mBullet[1] = (ImageView) view.findViewById(R.id.feature_bullet_2);
        // Set bullet one to black
        mBullet[0].setImageResource(R.drawable.page_indicator_black_bullet);

        MainViewPager viewPager = (MainViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new AccountFeaturesPagerAdapter(getActivity()));
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_text_view:
                goToLoginFragment();
                break;
        }
    }

    public void goToLoginFragment() {
        ((AccountActivity) getActivity()).nextPage();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < FeaturePagesEnum.values().length; i++) {
            mBullet[i].setImageResource(R.drawable.page_indicator_light_bullet);
        }
        mBullet[position].setImageResource(R.drawable.page_indicator_black_bullet);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
