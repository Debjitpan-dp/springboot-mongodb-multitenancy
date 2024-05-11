package com.nazeem.multidb.mongodb.controller;

import com.nazeem.multidb.mongodb.model.Customer;
import com.nazeem.multidb.mongodb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String save(@RequestBody Customer customer) {
        Customer customer1  = customerService.save(customer);
        return "Customer id: " + customer1.getCustomerId();
    }

    @GetMapping("/findById/{customerId}")
    public Customer findById(@PathVariable("customerId") String customerId) {
        return customerService.findByCustomerId(customerId);
    }

}
