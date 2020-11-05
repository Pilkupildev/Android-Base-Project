/*
 * Created by Muhamad Syafii
 * Thursday,5/11/2020
 * Copyright (c) 2020 All Rights Reserved.
 */

package com.syafii.androidbaseproject.model.repository;

import com.syafii.androidbaseproject.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Repository {

    @POST(" end point here")
    Call<UserResponse> authenticationUser(@Query("email") String email, @Query("password") String password);
}
