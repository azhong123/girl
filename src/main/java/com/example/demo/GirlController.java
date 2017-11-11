package com.example.demo;

import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 女孩的控制台
 * Created by Admin on 2017/11/11.
 */
@RestController
@RequestMapping(value = "/jap")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女孩的信息
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> findAllGirl(){
        return girlRepository.findAll();
    }

    /**
     * 查询单个女孩的信息
     * @param id 用户id
     * @return
     */
    @PostMapping(value = "/girl/{id}")
    public Girl findOneGirl(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 添加女孩信息
     * @param cupSize 罩杯
     * @param age 年龄
     * @return
     */
    @PostMapping(value = "/savegirl")
    public Girl saveGirl(@RequestParam("cupSize") String cupSize,
                         @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 更新一条女孩的数据，根据id
     * @param id
     * @param cupSize 罩杯
     * @param age 年龄
     * @return
     */
    @PutMapping(value = "/updategirl/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除用户信息
     * @param id
     */
    @DeleteMapping(value = "/deletegirl/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 通过年龄查询女生信息
     * @param age
     * @return
     */
    @GetMapping(value = "/findgirls/{age}")
    public List<Girl> findGirlByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 事务管理
     * 同时添加两个女生的信息
     */
    @PostMapping(value = "/savegirltwo")
    public void saveGirlTwo(){
        girlService.saveGirlTwo();
    }
}
