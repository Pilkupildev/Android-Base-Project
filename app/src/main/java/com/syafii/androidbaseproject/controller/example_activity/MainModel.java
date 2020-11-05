/*
 * Created by Muhamad Syafii
 * Thursday,5/11/2020
 * Copyright (c) 2020 All Rights Reserved.
 */

package com.syafii.androidbaseproject.controller.example_activity;

import com.syafii.androidbaseproject.model.UserResponse;
import com.syafii.androidbaseproject.model.repository.Repository;
import com.syafii.androidbaseproject.network.ApiService;
import com.syafii.androidbaseproject.util.constant.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainModel implements MainContract.Model {
    @Override
    public void authLogin(String email, String password, OnFinishedListener<UserResponse> listener) {
        Repository service = ApiService.getClient().create(Repository.class);
        Call<UserResponse> call = service.authenticationUser(email, password);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful() && response.body() !=null){
                    listener.onSuccess(response.body());
                }else{
                    listener.onFailure(Constant.MESSAGE_ERROR_REQUEST);
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                listener.onFailure(Constant.MESSAGE_ERROR_REQUEST);
            }
        });
    }
}
