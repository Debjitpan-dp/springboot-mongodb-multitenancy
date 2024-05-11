package in.debjitpan.multitenancy.service;

import in.debjitpan.multitenancy.dto.CustomerOrder;
import in.debjitpan.multitenancy.model.Customer;
import in.debjitpan.multitenancy.model.Order;
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
    private MongoTemplate mongoTemplate;





    public Order save(Order order){
        return mongoTemplate.save(order);
    }

    public CustomerOrder findCustomerOrders(String customerId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("customerId").is(customerId));

        //Find orders
        List<Order> orders = new ArrayList<>();
        orders = mongoTemplate.find(query, Order.class);

        //Find customer
        Customer customer = mongoTemplate.findOne(query, Customer.class);

        //creating customer's orders
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrder(orders);
        customerOrder.setCustomer(customer);

        return customerOrder;
    }

}
