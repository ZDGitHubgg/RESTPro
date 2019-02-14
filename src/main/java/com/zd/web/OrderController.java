package com.zd.web;

import com.zd.pojo.Order;
import com.zd.service.OrderService;
import oracle.jrockit.jfr.events.RequestableEventEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 获得所有订单
     * @param model
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        Collection<Order> orders = orderService.getAll();
        model.addAttribute("orderList",orders);
        return "order/list";
    }

    /**
     * 新增订单
     * @param order
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Order order){
        orderService.save(order);
        return "redirect:/order/list";
    }

    /**
     * 删除订单
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        orderService.delete(id);
        return "redirect:/order/list";
    }

    /**
     * 修改订单
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String update(@PathVariable("id") Integer id){
        orderService.get(id).setCode("已修改!");
        return "redirect:/order/list";
    }
}
