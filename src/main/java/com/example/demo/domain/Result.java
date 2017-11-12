package com.example.demo.domain;

/**
 * HTTP请求返回的最外层对象
 * Created by Admin on 2017/11/12.
 */
public class Result<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误OR正确的提示信息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }
}
