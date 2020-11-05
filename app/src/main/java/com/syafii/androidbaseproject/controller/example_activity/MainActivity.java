/*
 * Created by Muhamad Syafii
 * Thursday,5/11/2020
 * Copyright (c) 2020 All Rights Reserved.
 */

package com.syafii.androidbaseproject.controller.example_activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.syafii.androidbaseproject.R;
import com.syafii.androidbaseproject.controller.another_activity.AnotherActivity;
import com.syafii.androidbaseproject.util.ActivityUtils;
import com.syafii.androidbaseproject.util.CustomProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.tilEmail)
    TextInputLayout tilEmail;
    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;
    @BindView(R.id.etEmail)
    TextInputEditText etEmail;
    @BindView(R.id.etPassword)
    TextInputEditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    private MainContract.Presenter presenter;
    private CustomProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progressBar = new CustomProgressBar(this);
        /*if use auth with model
        presenter = new MainPresenter(this, new MainModel());
         */
        presenter = new MainPresenter(this);
        presenter.start();

    }

    @Override
    public void initView() {
        btnLogin.setOnClickListener(v -> {
            ActivityUtils.hideKeyboard(this);
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            presenter.doLogin(email, password);
        });
    }

    @Override
    public void showLoading() {
        progressBar.show();
    }

    @Override
    public void hideLoading() {
        progressBar.hide();
    }

    @Override
    public void showErrorEmail(String message) {
        if (!TextUtils.isEmpty(message)) {
            tilEmail.setError(message);
        }
    }

    @Override
    public void showErrorPassword(String message) {
        if (!TextUtils.isEmpty(message)) {
            tilPassword.setError(message);
        }
    }

    @Override
    public void loginFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginData(String message) {
        Toast.makeText(this, "Welcome" + message, Toast.LENGTH_SHORT).show();
        ActivityUtils.openActivity(this, AnotherActivity.class);
        finish();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }
}