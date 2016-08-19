package com.baya.bayatechandroid.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.baya.bayatechandroid.R;
import com.baya.bayatechandroid.activity.MainActivity;

/**
 * Copyright (c) 2016 BayaTech. All rights reserved.
 */
public class AccountAuthFragment extends Fragment implements View.OnClickListener {

    private EditText mEmailEditText;
    private EditText mPasswordEditText;

    public AccountAuthFragment() {
        // Recommended empty Constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_auth, container, false);
        initViews(view);
        return view;
    }

    public void initViews(View view) {

        mEmailEditText = (EditText) view.findViewById(R.id.email_edit_text);
        mPasswordEditText = (EditText) view.findViewById(R.id.password_edit_text);

        Button continueButton = (Button) view.findViewById(R.id.continue_button);
        continueButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.continue_button:
                signIn();
                break;
        }
    }

    private void signIn() {
        // do Sign email and password
        String email = mEmailEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        startMainActivity();
    }

    public void startMainActivity() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
