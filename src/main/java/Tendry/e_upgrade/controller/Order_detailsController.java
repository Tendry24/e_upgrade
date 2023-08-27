package Tendry.e_upgrade.controller;

import Tendry.e_upgrade.models.Order_details;
import Tendry.e_upgrade.services.Order_detailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/order_details")
public class Order_detailsController {

    private Order_detailsService service;

    @GetMapping
    public List<Order_details> getAllOrder_details() {
        return service.findAllOrder_details();
    }

    @GetMapping("/{id}")
    public Optional<Order_details> getOrder_detailsById(@PathVariable int id) {
        return service.findOrder_detailsById(id);
    }

    @PostMapping("/add")
    public Order_details addOrder_details(@RequestBody Order_details order_details) {
        return service.insert(order_details);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder_detailsById(@PathVariable int id, HttpStatus done, HttpStatus fail) {
        Boolean deletedOrder_details = service.delete(id);

        if (deletedOrder_details != null && deletedOrder_details.booleanValue()) {
            return new ResponseEntity<>(done.OK);
        } else {
            return new ResponseEntity<>(fail.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable int id, @RequestBody Order_details updatedOrder_details) {
        updatedOrder_details.setId(id);
        Order_details updated = service.update(updatedOrder_details);

        if (updated != null) {
            return new ResponseEntity<>("Category with ID " + id + " has been updated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Category with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
