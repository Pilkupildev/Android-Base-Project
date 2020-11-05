/*
 * Created by Muhamad Syafii
 * Thursday,5/11/2020
 * Copyright (c) 2020 All Rights Reserved.
 */

package com.syafii.androidbaseproject.util;

import android.util.Patterns;

public class ValidationUtils {
    public static boolean isEmpty(String string){
        boolean isValid = false;
        if (string == null){
            isValid = true;
        }else if (string.equals("")){
            isValid = true;
        }
        return isValid;
    }

    public static boolean isValidEmail(String string){
        boolean isValid = true;
        if (isEmpty(string)){
            isValid = false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(string).matches()){
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidPassword(String string){
        boolean isValid = true;
        if (isEmpty(string)){
            isValid = false;
        }else if (string.length() < 6){
            isValid = false;
        }
        return isValid;
    }
}
