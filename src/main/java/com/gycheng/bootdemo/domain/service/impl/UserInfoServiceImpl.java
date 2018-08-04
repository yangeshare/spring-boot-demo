package com.gycheng.bootdemo.domain.service.impl;

import com.gycheng.bootdemo.domain.dao.UserInfoMapper;
import com.gycheng.bootdemo.domain.model.UserInfo;
import com.gycheng.bootdemo.domain.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Author: G.Yang
 * DateTime: 2018年07月31日 18时54分
 * Function:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo queryUserInfoByUserId(String userId) {
        return userInfoMapper.selectByPrimaryKey(Integer.valueOf(userId));
    }
}
