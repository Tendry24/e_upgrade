package Tendry.e_upgrade.repository.oders;


import Tendry.e_upgrade.models.Order;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository extends GenericDAO {

    public OrderRepository(Connection connection) {
        super(connection);
    }

    @Override
    public void insert(Order toInsert) throws SQLException {
        String sql = "INSERT INTO \"order\" (user_id,order_date,total_bills) VALUES (?,?,?)";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            /*statement.setInt(1, toInsert.getId());*/
            statement.setInt(2,toInsert.getUser_id());
            statement.setTimestamp(3,toInsert.getOrder_date());
            statement.setDouble(4,toInsert.getTotal_bills());

            statement.executeUpdate();
        }
    }

    @Override
    public List<Order> findAllOrders() throws SQLException {
        List<Order> order = new ArrayList<>();
        String sql = "SELECT * FROM \"order\"";

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Order newOrder = extractOrderFromResultSet(resultSet);
                order.add(newOrder);
            }
        }
        return order;
    }

    @Override
    public Optional<Order> findOrderById(int id) throws SQLException {
        String sql = "SELECT * FROM \"order\" WHERE id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return Optional.of(extractOrderFromResultSet(resultSet));
                }
            }
            return Optional.empty();
        }
    }

    public List<Order> findOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM \"order\" WHERE order_date BETWEEN ? AND ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setTimestamp(1, Timestamp.valueOf(startDate));
            statement.setTimestamp(2, Timestamp.valueOf(endDate));

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order newOrder = extractOrderFromResultSet(resultSet);
                    orders.add(newOrder);
                }
            }
        }
        return orders;
    }


    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM \"order\" WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println( id + " has been deleted.");
            } else {
                System.out.println(  id + "not found.");
            }
        }
        return false;
    }

    public void update(Order updatedOrder) throws SQLException {
        String sql = "UPDATE \"order\" SET user_id =?,order_date=?,total_bills=? WHERE id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, updatedOrder.getId());
            statement.setInt(2, updatedOrder.getUser_id());
            statement.setTimestamp(3,updatedOrder.getOrder_date());
            statement.setDouble(4,updatedOrder.getTotal_bills());

            statement.executeUpdate();
        }
    }
    private Order extractOrderFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int user_id = resultSet.getInt("user_id");
        Timestamp order_date = resultSet.getTimestamp("order_date");
        Double total_bills = resultSet.getDouble("total_bills");

        return new Order(id, user_id,order_date,total_bills);
    }
}
