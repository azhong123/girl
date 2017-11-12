package com.example.demo.Controller;

import com.example.demo.Repository.GirlRepository;
import com.example.demo.Service.GirlService;
import com.example.demo.domain.Girl;
import com.example.demo.domain.Result;
import com.example.demo.utill.ResultUtill;
import com.sun.net.httpserver.Authenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 女孩的控制台
 * Created by Admin on 2017/11/11.
 */
@RestController
@RequestMapping(value = "/jap")
public class GirlController {

    //记录日志
    private final static Logger LOGGER = LoggerFactory.getLogger(GirlController.class);

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
        LOGGER.info("controller查询所有信息日志！！！！！！！！！");
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

    /**
     * 验证用户上传的信息，是否是满足程序设计  通过注解 @Valid
     *
     * @param girl Girl对象
     * @param bindingResult 提示信息
     * @return
     */
    @PostMapping(value = "/savegirlvaild")
    public Result<Girl> saveGirlValid(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //打印不满条件的提示信息
            return ResultUtill.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        Girl girlA = new Girl();
        girlA.setCupSize(girl.getCupSize());
        girlA.setAge(girl.getAge());
        girlA.setMoney(girl.getMoney());
        return ResultUtill.success(girlRepository.save(girlA));
    }

    /**
     * 通过年龄的判断识别是否需要将信息展示出来
     * age<14  ---> 女孩还在成长，请原谅
     * 14< age< 20  ---> 未成年信息禁止查看
     * 其实正常显示
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/findgirlbyage/{id}")
    public Result<Girl> findGirlByAgeAndException(@PathVariable Integer id) throws Exception{

        return ResultUtill.success(girlService.findGirlByAge(id));
    }
}
