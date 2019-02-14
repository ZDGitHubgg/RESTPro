package com.zd.service.impl;

import com.zd.dao.OrderDao;
import com.zd.pojo.Order;
import com.zd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Collection<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public Order get(Integer id) {
        return orderDao.get(id);
    }

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public void delete(Integer id) {
        orderDao.delete(id);
    }
}
