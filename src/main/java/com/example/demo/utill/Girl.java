package com.example.demo.utill;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * 女孩的实体类
 * Created by Admin on 2017/11/11.
 */
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private String cupSize;

    /**
     * 直接在属性上注解 并显示提示信息
     * @Min(value = 18,message = "未成年禁止入内！")
     */
    @Min(value = 18,message = "未成年禁止入内！")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Girl() {
    }
}
