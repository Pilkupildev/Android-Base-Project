/*
 * Created by Muhamad Syafii
 * Thursday,5/11/2020
 * Copyright (c) 2020 All Rights Reserved.
 */

package com.syafii.androidbaseproject.controller.example_activity;

import com.syafii.androidbaseproject.util.ValidationUtils;
import com.syafii.androidbaseproject.util.constant.Constant;

public class MainPresenter implements MainContract.Presenter{
    private final MainContract.View view;
//    private final MainContract.Model model;

    /* if use auth with model
    public MainPresenter(MainContract.View view, MainContract.Model model) {
        this.view = view;
        this.model = model;
        this.view.setPresenter(this);
    }
     */

    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public boolean validateEmail(String email) {
        boolean isValid = false;
        if (ValidationUtils.isEmpty(email)) {
            view.showErrorEmail(Constant.FIELD_REQUIRED);
        }else {
            view.showErrorEmail("");
            isValid = true;
        }
        return isValid;
    }

    @Override
    public boolean validatePassword(String password) {
        boolean isValid = false;
        if (ValidationUtils.isEmpty(password)) {
            view.showErrorPassword(Constant.FIELD_REQUIRED);
        }else {
            view.showErrorPassword("");
            isValid = true;
        }
        return isValid;
    }

    @Override
    public void doLogin(String email, String password) {
        boolean isValidEmail = validateEmail(email);
        boolean isValidPassword = validatePassword(password);
        if (isValidEmail && isValidPassword){
            view.showLoading();
            if (email.equals("test@test.com") && password.equals("123123")){
                view.hideLoading();
                view.showLoginData("test@test.com");
            }else{
                view.hideLoading();
                view.loginFailed(Constant.LOGIN_ERROR_MESSAGE);
            }

            /*if use auth with model*/
            /*
            model.authLogin(email, password, new BaseModel.OnFinishedListener<UserResponse>() {
                @Override
                public void onSuccess(UserResponse data) {
                }

                @Override
                public void onFailure(String message) {
                    view.hideLoading();
                    view.loginFailed(message);
                }
            });
             */
        }else{
            view.loginFailed(Constant.LOGIN_ERROR_MESSAGE);
        }

    }

    @Override
    public void start() {
        view.initView();
    }
}
