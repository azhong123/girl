package com.example.demo.Handle;

import com.example.demo.Exception.GirlException;
import com.example.demo.domain.Result;
import com.example.demo.utill.ResultUtill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 捕获异常的 类
 * Created by Admin on 2017/11/12.
 */
@ControllerAdvice
public class ExceptionHandle {

    /**
     * 虽然我们将异常捕获，不抛出，但如果我们要看不是我们自定义的异常，要看哪边出错了，
     * 这个时候我们可以通过日志的方式将错误打印出来
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 捕获异常并返回HTTP指定的最外层对象
     *
     * 注：由于@RestController没有 要在方法上@ResponseBody
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handException(Exception e){
        //判断捕获的异常是否是自己自定义的异常
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtill.error(girlException.getCode(),e.getMessage());
        }else {
            LOGGER.info("【系统异常：】-->{}",e);
            return ResultUtill.error(-1,"未知错误！！");
        }

    }
}
