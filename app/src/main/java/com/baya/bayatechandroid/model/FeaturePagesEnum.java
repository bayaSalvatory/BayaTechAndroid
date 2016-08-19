package com.baya.bayatechandroid.model;

import com.baya.bayatechandroid.R;

/**
 * Copyright (c) 2016 BayaTech. All rights reserved.
 */
public enum FeaturePagesEnum {
    PAGE_1(R.string.no_stress, R.drawable.place_holder_1),  // This page is unique and its values are set directly on the layout.
    PAGE_2(R.string.we_go_u_covered, R.drawable.place_holder_2);

    private int mPageTextId;
    private int mPageImageId;

    private FeaturePagesEnum(int PageTextId, int pageImage) {
        mPageTextId = PageTextId;
        mPageImageId = pageImage;
    }

    public int getTextId() {
        return mPageTextId;
    }

    public int getImageId() {
        return mPageImageId;
    }
}
