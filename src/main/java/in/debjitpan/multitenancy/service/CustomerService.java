package in.debjitpan.multitenancy.service;

import in.debjitpan.multitenancy.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Customer save(Customer customer){
        return mongoTemplate.save(customer);
    }

    public List<Customer> findAll(){
        return mongoTemplate.findAll(Customer.class);
    }

    public Customer findByCustomerId(String customerId) {
        return mongoTemplate.findById(customerId,Customer.class);
    }
}
