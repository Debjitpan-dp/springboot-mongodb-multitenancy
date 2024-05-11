package com.nazeem.multidb.mongodb.service;

import com.nazeem.multidb.mongodb.dto.CustomerOrder;
import com.nazeem.multidb.mongodb.model.Customer;
import com.nazeem.multidb.mongodb.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {


    @Autowired
    private MongoTemplate orderDbMongoTemplate;

    @Autowired
    MongoTemplate customerDbMongoTemplate;





    public Order save(Order order){
        return orderDbMongoTemplate.save(order);
    }

    public CustomerOrder findCustomerOrders(String customerId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("customerId").is(customerId));

        //Find orders
        List<Order> orders = new ArrayList<>();
        orders = orderDbMongoTemplate.find(query, Order.class);

        //Find customer
        Customer customer = customerDbMongoTemplate.findOne(query, Customer.class);

        //creating customer's orders
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrder(orders);
        customerOrder.setCustomer(customer);

        return customerOrder;
    }

}
