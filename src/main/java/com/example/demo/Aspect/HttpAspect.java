package com.example.demo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 1.pom.xml加入AOP.jar包  2.创建记录日志对象  3.log4记录并打印日志
 * Created by Admin on 2017/11/12.
 */
@Aspect
@Component
public class HttpAspect {

    /**
     * 通过org.slf4j.Logger 记录并打印日志
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.demo.Controller.GirlController.*(..))")
    public void log(){
    }

    /**
     * 程序运行前必须执行的方法
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =attributes.getRequest();

        //获取请求URL
        LOGGER.info("URL={}",request.getRequestURI());

        //获取请求方式
        LOGGER.info("method={}",request.getMethod());

        //获取ip
        LOGGER.info("IP={}",request.getRemoteAddr());

        //获取请求类名和方法名
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //获取请求的参数
        LOGGER.info("args={}",joinPoint.getArgs());
    }

    /**
     * 程序执行后必须执行的方法
     */
    @After("log()")
    public void doAfter(){
        LOGGER.info("运行后记录日志！！！！！！！！！！");
    }

    /**
     * 数据请求后，返回的结果，并记录日志
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        LOGGER.info("response={}",object.toString());
    }
}
