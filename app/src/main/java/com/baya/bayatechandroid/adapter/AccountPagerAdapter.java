package com.baya.bayatechandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.baya.bayatechandroid.fragment.AccountAuthFragment;
import com.baya.bayatechandroid.fragment.AccountOAuthContainerFragment;

/**
 * Copyright (c) 2016 BayaTech. All rights reserved.
 */
public class AccountPagerAdapter extends FragmentPagerAdapter {

    public AccountPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AccountOAuthContainerFragment();
            case 1:
                return new AccountAuthFragment();
            default:
                return new AccountOAuthContainerFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
