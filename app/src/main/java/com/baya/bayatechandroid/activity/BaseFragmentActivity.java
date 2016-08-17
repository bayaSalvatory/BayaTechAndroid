package com.baya.bayatechandroid.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.baya.bayatechandroid.listener.FragmentOnBackPressedListener;

/**
 * Copyright (c) 2016 BayaTech. All rights reserved.
 */
public class BaseFragmentActivity extends AppCompatActivity {
    private static final String TAG = BaseFragmentActivity.class.getSimpleName();

    /**
     * This method is used to switch between fragments
     *
     * @param newFragment
     * @param fragmentManager
     * @param container
     * @param fragmentTag
     * @param enterAnimation
     * @param popEnter
     * @param popExit
     * @param exitAnimation
     */
    public static void switchFragment(Fragment newFragment, FragmentManager fragmentManager, int container,
                                      String fragmentTag, int enterAnimation,
                                      int popEnter, int popExit, int exitAnimation) {
        Log.d(TAG, String.format("switchFragment: tag: %s, enterAnimation: %d, " +
                        "popEnter: %d, popExit: %d, exitAnimation: %d",
                fragmentTag, enterAnimation, popEnter, popExit, exitAnimation
        ));
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(enterAnimation, popEnter, popExit, exitAnimation);
        transaction.replace(container, newFragment, fragmentTag);
        transaction.addToBackStack(fragmentTag);
        transaction.commit();
    }

    public static void replaceFragment(int container, FragmentManager fragmentManager, Fragment fragment, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(container, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

//    /**
//     * Replace a fragment using Sliding In Sliding Out animations
//     * The root view of the fragment has to be SlidingRelativeLayout because an Object Animator is
//     * used instead a View Animator.
//     *
//     * @param fragmentManager
//     * @param newFragment
//     * @param tag             The Fragment name
//     */
//    public void replaceFragmentWithSlideInOutAnim(int container, FragmentManager fragmentManager, Fragment newFragment, String tag) {
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.setCustomAnimations(R.anim.onboard_slide_in_up, R.anim.onboard_slide_out_up,
//                R.anim.onboard_slide_in_down, R.anim.onboard_slide_out_down);
//        transaction.addToBackStack(tag);
//        transaction.replace(container, newFragment, tag);
//        transaction.commit();
//    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            FragmentOnBackPressedListener fragment = (FragmentOnBackPressedListener) getCurrentFragment();
            if (fragment != null) {
                fragment.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }

    private Fragment getCurrentFragment() {
        String fragmentTag = getSupportFragmentManager().getBackStackEntryAt(
                getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
        return getSupportFragmentManager().findFragmentByTag(fragmentTag);
    }
}