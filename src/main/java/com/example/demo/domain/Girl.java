package com.example.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

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

    @NotNull(message = "金额必须输入")
    private Double money;
    /**
     * 直接在属性上注解 并显示提示信息
     * @Min(value = 18,message = "未成年禁止入内！")
     */
    @Min(value = 18,message = "未成年禁止入内！")
    private Integer age;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

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

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", money=" + money +
                ", age=" + age +
                '}';
    }
}
