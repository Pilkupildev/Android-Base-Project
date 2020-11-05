/*
 * Created by Muhamad Syafii
 * Thursday,5/11/2020
 * Copyright (c) 2020 All Rights Reserved.
 */

package com.syafii.androidbaseproject.controller.example_activity;

import com.syafii.androidbaseproject.base.BaseModel;
import com.syafii.androidbaseproject.base.BasePresenter;
import com.syafii.androidbaseproject.base.BaseView;
import com.syafii.androidbaseproject.model.UserResponse;

public interface MainContract {
    interface View extends BaseView<Presenter>{
        void initView();
        void showLoading();
        void hideLoading();
        void showErrorEmail(String message);
        void showErrorPassword(String message);
        void loginFailed(String message);
        void showLoginData(String message);

    }

    interface Presenter extends BasePresenter{
        boolean validateEmail(String email);
        boolean validatePassword(String password);
        void doLogin(String email, String password);
    }

    interface Model extends BaseModel{
        void authLogin(String email, String password, BaseModel.OnFinishedListener<UserResponse> listener);
    }
}
