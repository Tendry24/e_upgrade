package Tendry.e_upgrade.controller;

import Tendry.e_upgrade.models.Order;
import Tendry.e_upgrade.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {

    private OrderService service;

    @GetMapping("/allOrders")
    public List<Order> getAllOrders() {
        return service.findAllOrders();
    }

}
