package com.zd.service;

import com.zd.pojo.Order;

import java.util.Collection;

public interface OrderService {
    Collection<Order> getAll();

    Order get(Integer id);

    void save(Order order);

    void delete(Integer id);

}
