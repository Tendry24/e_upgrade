package Tendry.e_upgrade.repository.oders;


import Tendry.e_upgrade.models.Order;
import org.springframework.stereotype.Repository;

import java.sql.*;
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

    }

    @Override
    public List<Order> findAllOrders() throws SQLException {
        List<Order> order = new ArrayList<>();
        String sql = "SELECT * FROM \"order\"";

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Order newOrder = extractTodoFromResultSet(resultSet);
                order.add(newOrder);
            }
        }
        return order;
    }

    @Override
    public Optional<Order> findOrderById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    private Order extractTodoFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int user_id = resultSet.getInt("user_id");
        Timestamp order_date = resultSet.getTimestamp("order_date");
        Double total_bills = resultSet.getDouble("total_bills");

        return new Order(id, user_id,order_date,total_bills);
    }
}
