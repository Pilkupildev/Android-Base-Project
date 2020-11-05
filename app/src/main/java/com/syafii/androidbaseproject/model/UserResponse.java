/*
 * Created by Muhamad Syafii
 * Thursday,5/11/2020
 * Copyright (c) 2020 All Rights Reserved.
 */

package com.syafii.androidbaseproject.model;

import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
