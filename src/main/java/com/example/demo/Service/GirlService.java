package com.example.demo.Service;

import com.example.demo.Exception.GirlException;
import com.example.demo.Repository.GirlRepository;
import com.example.demo.domain.Girl;
import com.example.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 女生的业务逻辑层
 * Created by Admin on 2017/11/11.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void saveGirlTwo() throws RuntimeException {

            Girl girlA = new Girl();
            girlA.setAge(20);
            girlA.setCupSize("A");
            girlRepository.save(girlA);

            Girl girlB = new Girl();
            girlB.setAge(20);
            girlB.setCupSize("B");
            girlRepository.save(girlB);
        }

    public Girl findGirlByAge(Integer id) throws Exception{
         Girl girl=girlRepository.findOne(id);
         Integer age = girl.getAge();
        if(age < 14){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age < 20 && age > 14){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        return girl;
    }

}
