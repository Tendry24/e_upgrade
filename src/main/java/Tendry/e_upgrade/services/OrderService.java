package Tendry.e_upgrade.services;

import Tendry.e_upgrade.models.Order;
import Tendry.e_upgrade.repository.oders.OrderRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository order;

    public OrderService(OrderRepository order) {
        this.order = order;
    }

    public List<Order> findAllOrders() {
        try {
            return order.findAllOrders();
        } catch (SQLException e) {
            throw new RuntimeException("Error");
        }
    }

    public Optional<Order> findOrderById(int id){
        try{
            return order.findOrderById(id);
        } catch (SQLException e){
            throw new RuntimeException("Error");
        }
    }

    public Order insert(Order toInsert){
        try{
            this.order.insert(toInsert);
            return toInsert;
        } catch (SQLException e){
            throw new RuntimeException("Error");
        }
    }


    public Optional<Order> delete(int toDelete){
        try {
            this.order.delete(toDelete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Order update(Order updatedOrder) {
        try {
            this.order.update(updatedOrder);
            return updatedOrder;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating Order");
        }
    }
}
