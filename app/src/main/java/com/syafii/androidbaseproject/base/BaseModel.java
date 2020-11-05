/*
 * Created by Muhamad Syafii
 * Thursday,5/11/2020
 * Copyright (c) 2020 All Rights Reserved.
 */

package com.syafii.androidbaseproject.base;

public interface BaseModel {
    interface OnFinishedListener<T> {
        void onSuccess(T data);
        void onFailure(String message);
    }
}
