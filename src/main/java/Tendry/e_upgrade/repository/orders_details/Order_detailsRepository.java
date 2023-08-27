package Tendry.e_upgrade.repository.orders_details;


import Tendry.e_upgrade.models.Order_details;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class Order_detailsRepository extends GenericDAO{
    public Order_detailsRepository(Connection connection) {
        super(connection);
    }

    @Override
    public void insert(Order_details toInsert) throws SQLException {
        String sql = "INSERT INTO order_details(order_id,product_id,quantity,unit_price) VALUES (?,?,?,?)";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1,toInsert.getOrder_id());
            statement.setInt(2,toInsert.getProduct_id());
            statement.setInt(3,toInsert.getQuantity());
            statement.setDouble(4,toInsert.getUnit_price());

            statement.executeUpdate();
        }
    }

    @Override
    public List<Order_details> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<Order_details> findById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
