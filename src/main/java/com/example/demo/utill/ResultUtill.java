package com.example.demo.utill;

import com.example.demo.domain.Result;

/**
 * 返回结果对象类型
 * Created by Admin on 2017/11/12.
 */
public class ResultUtill {

    /**
     * 正确返回的结果
     *
     * @param object 正确返回的对象
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * 正确返回的结果  可能返回的没有对象
     * @return
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 错误返回的最外层对象
     * @param code 错误码
     * @param msg 提示信息
     * @return
     */
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
