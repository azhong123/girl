package com.example.demo.Exception;

import com.example.enums.ResultEnum;

/**
 * 自定义异常
 * Created by Admin on 2017/11/12.
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public GirlException() {
    }
}
