package com.gycheng.bootdemo.domain.service;

import com.gycheng.bootdemo.domain.model.UserInfo;

/**
 * Author: G.Yang
 * DateTime: 2018年08月01日 09时15分
 * Function:
 */
public interface UserInfoService {

    UserInfo queryUserInfoByUserId(String userId);
}
