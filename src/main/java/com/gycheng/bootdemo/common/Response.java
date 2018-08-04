package com.gycheng.bootdemo.common;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Author: G.Yang
 * DateTime: 2018年07月31日 20时59分
 * Function:
 */
public class Response<T> {
    private int code;
    private String desc;
    T result;

    Response(int code, String desc, T result) {
        this.code = code;
        this.desc = desc;
        this.result = result;
    }

    Response(HttpCodeEnum httpCodeEnum, T result){
        this.code = httpCodeEnum.getCode();
        this.desc = httpCodeEnum.getDesc();
        this.result = result;
    }

    public static <T> Response ok(T result){
        return new Response<T>(HttpCodeEnum.SUCCESS, result);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code, desc, result);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", code)
                .add("desc", desc)
                .add("result", result)
                .toString();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
