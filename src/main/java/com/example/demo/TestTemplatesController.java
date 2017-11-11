package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 测试 controller 配合模板使用
 * Created by Admin on 2017/11/11.
 */
public class TestTemplatesController {

    @RequestMapping(value = "testindex" , method = RequestMethod.GET)
    public String testTemplate(){
        return "index";
    }
}
