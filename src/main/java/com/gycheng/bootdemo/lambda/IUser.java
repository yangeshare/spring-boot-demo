package com.gycheng.bootdemo.lambda;

public @FunctionalInterface interface IUser {
    UserInfo getUserInfo(String userId);
}
