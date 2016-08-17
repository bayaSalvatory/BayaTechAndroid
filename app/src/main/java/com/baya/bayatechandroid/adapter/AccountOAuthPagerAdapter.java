package com.baya.bayatechandroid.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2016 BayaTech. All rights reserved.
 */
public class AccountOAuthPagerAdapter extends PagerAdapter{

    private List<String> pages = new ArrayList<>();
    private Context context;

    public AccountOAuthPagerAdapter(){

    }

    public AccountOAuthPagerAdapter(Context context, List<String> pages){
        this.context = context;
        pages.clear();
        pages.addAll(pages);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }
}
