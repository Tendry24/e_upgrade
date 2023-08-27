package Tendry.e_upgrade.controller;

import Tendry.e_upgrade.models.Order;
import Tendry.e_upgrade.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private OrderService service;

    @GetMapping
    public List<Order> getAllOrders() {
        return service.findAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> findOrdersById(@PathVariable int id){
        return service.findOrderById(id);
    }

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order orders ) {
        return service.insert(orders);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable int id , HttpStatus done , HttpStatus fail) {
        Boolean deletedOrder = service.delete(id);

        if (deletedOrder != null && deletedOrder.booleanValue()) {
            return new ResponseEntity<>( done.OK);
        } else {
            return new ResponseEntity<>(fail.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable int id, @RequestBody Order updatedOrder) {
        updatedOrder.setId(id);
        Order updated = service.update(updatedOrder);

        if (updated != null) {
            return new ResponseEntity<>("Category with ID " + id + " has been updated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Category with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
