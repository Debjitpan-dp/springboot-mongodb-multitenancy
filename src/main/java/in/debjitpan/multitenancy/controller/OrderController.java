package in.debjitpan.multitenancy.controller;

import in.debjitpan.multitenancy.dto.CustomerOrder;
import in.debjitpan.multitenancy.model.Order;
import in.debjitpan.multitenancy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
