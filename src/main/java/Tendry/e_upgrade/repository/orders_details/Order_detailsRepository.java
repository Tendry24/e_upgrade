package Tendry.e_upgrade.repository.orders_details;


import Tendry.e_upgrade.models.Order_details;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
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
        List<Order_details> allDetails = new ArrayList<>();
        String sql = "SELECT * FROM order_details";

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Order_details details = extractOrder_detailsFromResultSet(resultSet);
                allDetails.add(details);
            }
        }
        return allDetails;
    }

    @Override
    public Optional<Order_details> findById(int id) throws SQLException {
        String sql = "SELECT * FROM order_details WHERE id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    return Optional.of(extractOrder_detailsFromResultSet(resultSet));
                }
            }
            return Optional.empty();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM order_details WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println( id + " has been deleted.");
            } else {
                System.out.println(  id + "not found.");
            }
        }
    }

    public void update(Order_details updatedOrder_details) throws SQLException {
        String sql = "UPDATE order_details SET order_id =?,product_id =?,quantity =?,unit_price =? WHERE id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, updatedOrder_details.getId());
            statement.setInt(2, updatedOrder_details.getOrder_id());
            statement.setInt(3,updatedOrder_details.getProduct_id());
            statement.setInt(4,updatedOrder_details.getQuantity());
            statement.setDouble(5,updatedOrder_details.getUnit_price());

            statement.executeUpdate();
        }
    }


    private Order_details extractOrder_detailsFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int order_id = resultSet.getInt("order_id");
        int product_id = resultSet.getInt("product_id");
        int quantity = resultSet.getInt("quantity");
        Double unitPrice = resultSet.getDouble("unit_price");

        return new Order_details(id, order_id,product_id,quantity,unitPrice);
    }
}
