package com.nazeem.multidb.mongodb.service;

import com.nazeem.multidb.mongodb.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

@Service
public class CustomerService {

    @Autowired
    private MongoTemplate customerDbMongoTemplate;

    public Customer save(Customer customer){
        return customerDbMongoTemplate.save(customer);
    }

    public List<Customer> findAll(){
        return customerDbMongoTemplate.findAll(Customer.class);
    }

    public Customer findByCustomerId(String customerId) {
        return customerDbMongoTemplate.findById(customerId,Customer.class);
    }
}
