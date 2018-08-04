package com.gycheng.bootdemo.common;

/**
 * Author: G.Yang
 * DateTime: 2018年07月31日 21时15分
 * Function:
 */
public enum HttpCodeEnum {
    SUCCESS(200, "success"),
    FAILED(400, "failed");

    private int code;
    private String desc;

    HttpCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
