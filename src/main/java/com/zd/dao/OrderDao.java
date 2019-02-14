package com.zd.dao;

import com.zd.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderDao {
    private static Map<Integer,Order> orders = null;
    static{
        orders = new HashMap<Integer, Order>();
        orders.put(1,new Order(1,"订单1",10.0));
        orders.put(2,new Order(2,"订单2",11.0));
        orders.put(3,new Order(3,"订单3",13.0));
        orders.put(4,new Order(4,"订单4",14.0));
        orders.put(5,new Order(5,"订单5",15.0));
    }
    public static  Integer initId = 6; //记录id

    /**
     * 保存/更新 order
     * @param order
     */
    public  void save(Order order){
        if (order.getId() == null)
        {
            order.setId(initId++);
        }
        orders.put(order.getId(),order);
    }

    /**
     * 返回所有数据
     * @return
     */
    public Collection<Order> getAll(){
        return  orders.values();
    }

    /**
     * 获取数据
     * @param id
     * @return
     */
    public Order get(Integer id){
        return  orders.get(id);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Integer id)
    {
        orders.remove(id);
    }
}
