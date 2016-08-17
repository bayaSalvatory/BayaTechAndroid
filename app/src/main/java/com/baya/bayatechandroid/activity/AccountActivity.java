package com.baya.bayatechandroid.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.baya.bayatechandroid.R;
import com.baya.bayatechandroid.adapter.AccountPagerAdapter;

/**
 * Copyright (c) 2016 BayaTech. All rights reserved.
 */
public class AccountActivity extends BaseFragmentActivity {

    private static final String ACCOUNT_OAUTH_CONTAINER_FRAG = "oauthContainerFrag";
    private ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        setViewPagerAdapter();
    }

    public void setViewPagerAdapter() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new AccountPagerAdapter(getSupportFragmentManager()));
    }

}
