package com.example.demo.Controller;

import com.example.demo.Properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 测试调用不同的配置
 * Created by Admin on 2017/11/9.
 */
//@RestController
@RestController
@RequestMapping(value = "hello")
public class TestPropertiesController {

    @Autowired
    private GirlProperties girlProperties;

    /**
     * 多个url 映射 ->@RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
     * 通过获取映射URL 路径获取数据，@RequestParam(value = "id",required（是否必填） = false,defaultValue（默认值） = "10"
     * @return
     */
    //@RequestMapping(value = "say",method = RequestMethod.POST)
    @PostMapping(value = "/say")
    public String Test(@RequestParam(value = "id",required = false,defaultValue = "10") Integer id){
        //return girlProperties.getCupSize()+girlProperties.getAge();
        return "id:"+id;
    }

}
