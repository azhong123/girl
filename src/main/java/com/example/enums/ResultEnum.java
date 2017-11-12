package com.example.enums;

/**
 * 创建返回结果的 异常枚举对象 便于管理
 * Created by Admin on 2017/11/12.
 */
public enum ResultEnum {
    UNKOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"女孩还在成长，请原谅！！sorry--"),
    MIDDLE_SCHOOL(101,"未成年信息禁止查看！！sorry--")
;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}
