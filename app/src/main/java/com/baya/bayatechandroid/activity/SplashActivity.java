package com.baya.bayatechandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.baya.bayatechandroid.R;

/**
 * Copyright (c) 2016 BayaTech. All rights reserved.
 */
public class SplashActivity extends AppCompatActivity {

    private TextView mAppNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mAppNameView = (TextView) findViewById(R.id.app_name_text_view);
        startSpinningAnimation(mAppNameView);
        startBayaTechAppOnDelayed(4000);
    }

    /**
     * This shows the mandatory splash screen.
     *
     * @param timeMilliSec time required to show splash screen
     */
    public void startBayaTechAppOnDelayed(int timeMilliSec) {
        Handler handler = new Handler();
        final Runnable startActivityRunnable = new Runnable() {
            @Override
            public void run() {
                startAccountActivity();
            }
        };
        handler.postDelayed(startActivityRunnable, timeMilliSec);
    }

    public void startSpinningAnimation(View view) {
        Animation rotation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        rotation.setRepeatCount(10);
        view.startAnimation(rotation);
    }

    public void startAccountActivity() {
        mAppNameView.clearAnimation();

        Intent intent = new Intent(SplashActivity.this, AccountActivity.class);
        startActivity(intent);
        finish();
    }

}
