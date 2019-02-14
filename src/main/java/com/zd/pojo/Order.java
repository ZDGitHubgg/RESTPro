package com.zd.pojo;

import org.springframework.stereotype.Component;

@Component
public class Order {
    private String code;
    private Integer id;
    private Double money;

    public Order() {
    }

    public Order(Integer id, String code, Double money) {
        this.code = code;
        this.id = id;
        this.money = money;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
