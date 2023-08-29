package Tendry.e_upgrade.services;

import Tendry.e_upgrade.models.Order_details;
import Tendry.e_upgrade.repository.orders_details.Order_detailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class Order_detailsService {
    private Order_detailsRepository order_details;

    public List<Order_details> findAllOrder_details() {
        try {
            return order_details.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error");
        }
    }

    public Optional<Order_details> findOrder_detailsById(int id) {
        try {
            return order_details.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Error");
        }
    }

    public Order_details insert(Order_details toInsert) {
        try {
            this.order_details.insert(toInsert);
            return toInsert;
        } catch (SQLException e) {
            throw new RuntimeException("Error");
        }
    }


    public boolean delete(int id) {
        try {
            order_details.delete(id);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Order_details update(Order_details updatedCategory) {
        try {
            this.order_details.update(updatedCategory);
            return updatedCategory;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating category");
        }
    }
}
