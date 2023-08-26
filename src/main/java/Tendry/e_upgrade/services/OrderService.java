package Tendry.e_upgrade.services;

import Tendry.e_upgrade.models.Order;
import Tendry.e_upgrade.repository.oders.OrderRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

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
}
