package in.debjitpan.multitenancy.dto;

import in.debjitpan.multitenancy.model.Customer;
import in.debjitpan.multitenancy.model.Order;
import lombok.Data;

import java.util.List;

@Data
public class CustomerOrder {
    Customer customer;
    List<Order> order;
}
