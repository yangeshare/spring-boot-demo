package com.gycheng.bootdemo.domain.controller;

import com.gycheng.bootdemo.common.Response;
import com.gycheng.bootdemo.domain.model.UserInfo;
import com.gycheng.bootdemo.domain.service.UserInfoService;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: G.Yang
 * DateTime: 2018年07月31日 18时02分
 * Function:
 */

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiParam(value = "getUserInfoByUserId")
    @GetMapping("/info")
    public Response getUserInfo(@RequestParam("id") String userId){
        UserInfo userInfo = userInfoService.queryUserInfoByUserId(userId);
        logger.info(userInfo.getPhone());
        return Response.ok(userInfo);
    }

    @Autowired
    UserInfoService userInfoService;
}
