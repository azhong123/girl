package com.example.demo;

import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.NoRollbackRuleAttribute;

import javax.transaction.Transactional;
import java.beans.Transient;

/**
 * 女生的业务逻辑层
 * Created by Admin on 2017/11/11.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void saveGirlTwo() throws Exception{

            Girl girlA = new Girl();
            girlA.setAge(20);
            girlA.setCupSize("A");
            girlRepository.save(girlA);

            Girl girlB = new Girl();
            girlB.setAge(20);
            girlB.setCupSize("B");
            girlRepository.save(girlB);

        throw new RuntimeException("test");

        }

}
