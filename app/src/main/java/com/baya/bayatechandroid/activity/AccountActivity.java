package com.baya.bayatechandroid.activity;

import android.os.Bundle;

import com.baya.bayatechandroid.R;
import com.baya.bayatechandroid.adapter.AccountPagerAdapter;
import com.baya.bayatechandroid.views.MainViewPager;

/**
 * Copyright (c) 2016 BayaTech. All rights reserved.
 */
public class AccountActivity extends BaseFragmentActivity {

    private MainViewPager mViewPager;
    private int mInitialPage = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        setViewPagerAdapter();
    }

    public void setViewPagerAdapter() {
        mViewPager = (MainViewPager) findViewById(R.id.viewpager);
        if (mViewPager == null) return;
        mViewPager.setPagingEnabled(false);
        mViewPager.setAdapter(new AccountPagerAdapter(getSupportFragmentManager()));
    }

    public void previousPage() {
        if (mViewPager.getCurrentItem() > 0) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1, true);
        }
    }

    public void nextPage() {
        if (mViewPager.getChildCount() > 0) {
            mViewPager.setCurrentItem(1, true);
        }
    }

    public void setInitialPage(int initialPage) {
        mInitialPage = initialPage;
    }

    @Override
    public void onBackPressed() {
        handleViewPagerBackPressed();
    }

    public void handleViewPagerBackPressed() {
        if (mViewPager.getCurrentItem() == mInitialPage) {
            finish();
        } else if (mViewPager.getCurrentItem() > mInitialPage) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1, true);
        } else {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
        }
    }
}
