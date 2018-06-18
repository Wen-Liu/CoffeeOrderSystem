package com.wenliu.coffeeordersystem;

import android.content.SharedPreferences;

public class UserManager {

    private static final UserManager ourInstance = new UserManager();

    private String mUserName;
    private String mUserImage;
    private String mUserEmail = "Wen_demo@awscafe.tw";
    private SharedPreferences mUserData;

    public static UserManager getInstance() {
        return ourInstance;
    }

    private UserManager() {

    }

    public String getUserEmail() {
        return mUserEmail;
    }
}
