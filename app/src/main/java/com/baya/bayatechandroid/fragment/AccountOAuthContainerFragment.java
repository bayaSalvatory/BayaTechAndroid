package com.baya.bayatechandroid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baya.bayatechandroid.R;

/**
 * Copyright (c) 2016 BayaTech. All rights reserved.
 */
public class AccountOAuthContainerFragment extends Fragment {

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

    }
}
