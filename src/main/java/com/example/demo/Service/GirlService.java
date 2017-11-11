package com.example.demo.Service;

import com.example.demo.Repository.GirlRepository;
import com.example.demo.utill.Girl;
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
    public void saveGirlTwo() {

            Girl girlA = new Girl();
            girlA.setAge(20);
            girlA.setCupSize("A");
            girlRepository.save(girlA);

            Girl girlB = new Girl();
            girlB.setAge(20);
            girlB.setCupSize("B");
            girlRepository.save(girlB);
        }

}
