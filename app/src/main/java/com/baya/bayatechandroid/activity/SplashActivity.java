package com.baya.bayatechandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.baya.bayatechandroid.R;

/**
 * Copyright (c) 2016 BayaTech. All rights reserved.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startBayaTechAppOnDelayed(2000);
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


    public void startAccountActivity() {
        Intent intent = new Intent(SplashActivity.this, AccountActivity.class);
        startActivity(intent);
        finish();
    }

}
