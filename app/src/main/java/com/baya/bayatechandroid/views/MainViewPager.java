package com.baya.bayatechandroid.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;

/**
 * Copyright (c) 2016 BayaTech. All rights reserved.
 */
public class MainViewPager extends ViewPager {
    private FixedSpeedScroller mScroller = null;
    private boolean isPagingEnabled = true;

    public MainViewPager(Context context) {
        super(context);
        init();
    }

    public MainViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /*
     * Override the Scroller instance with our own class so we can change the
     * duration
     */
    private void init() {
        try {
            Class<?> viewpager = ViewPager.class;
            Field scroller = viewpager.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            mScroller = new FixedSpeedScroller(getContext(),
                    new DecelerateInterpolator());
            scroller.set(this, mScroller);
        } catch (Exception ignored) {
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }

    public void setPagingEnabled(boolean b) {
        this.isPagingEnabled = b;
    }

    /*
     * Set the factor by which the duration will change
     */
    public void setScrollDuration(int duration) {
        mScroller.setScrollDuration(duration);
    }

    private class FixedSpeedScroller extends Scroller {
        private int mDuration = 500;

        public FixedSpeedScroller(Context context) {
            super(context);
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator, boolean flywheel) {
            super(context, interpolator, flywheel);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            // Ignore received duration, use fixed one instead
            super.startScroll(startX, startY, dx, dy, mDuration);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy) {
            // Ignore received duration, use fixed one instead
            super.startScroll(startX, startY, dx, dy, mDuration);
        }

        public void setScrollDuration(int duration) {
            mDuration = duration;
        }
    }
}
