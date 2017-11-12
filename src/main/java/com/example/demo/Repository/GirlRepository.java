package com.example.demo.Repository;

import com.example.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 女孩的数据控制层接口
 * Created by Admin on 2017/11/11.
 */
@Repository
public interface GirlRepository extends JpaRepository<Girl,Integer>{

    public List<Girl> findByAge(Integer age);
}
