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
public class OrderController {

    private OrderService service;

    @GetMapping("/allOrders")
    public List<Order> getAllOrders() {
        return service.findAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Optional<Order> findOrdersById(@PathVariable int id){
        return service.findOrderById(id);
    }

    @PostMapping("/addOrders")
    public Order addOrder(@RequestBody Order orders ) {
        return service.insert(orders);
    }


    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable int id , HttpStatus done , HttpStatus fail) {
        Optional<Order> deletedOrder = service.delete(id);

        if (deletedOrder.isPresent()) {
            return new ResponseEntity<>( done.OK);
        } else {
            return new ResponseEntity<>(fail.NOT_FOUND);
        }
    }

    @PutMapping("/updateOrder/{id}")
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
