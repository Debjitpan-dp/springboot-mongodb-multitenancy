package com.nazeem.multidb.mongodb.dto;

import lombok.Data;
import com.nazeem.multidb.mongodb.model.*;

import java.util.List;

@Data
public class CustomerOrder {
    Customer customer;
    List<Order> order;
}
