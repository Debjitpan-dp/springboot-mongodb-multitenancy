package com.nazeem.multidb.mongodb.controller;

import com.nazeem.multidb.mongodb.dto.CustomerOrder;
import com.nazeem.multidb.mongodb.model.Order;
import com.nazeem.multidb.mongodb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public String save(@RequestBody Order order) {
        Order order1  = orderService.save(order);
        return "Order id: " + order1.getOrderId();
    }

    @GetMapping("/findCustomerOrders/{customerId}")
    public CustomerOrder findCustomerOrders(@PathVariable("customerId") String customerId) {
        return orderService.findCustomerOrders(customerId);
    }

}
