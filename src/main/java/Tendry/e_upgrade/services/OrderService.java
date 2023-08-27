package Tendry.e_upgrade.services;

import Tendry.e_upgrade.models.Order;
import Tendry.e_upgrade.repository.oders.OrderRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

import java.time.LocalDateTime;
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

    public List<Order> findOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        try {
            return order.findOrdersByDateRange(startDate, endDate);
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching orders within date range", e);
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


    public boolean delete(int id) {
        try {
             order.delete(id);
             return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
