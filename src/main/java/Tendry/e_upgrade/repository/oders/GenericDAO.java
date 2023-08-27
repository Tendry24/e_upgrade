package Tendry.e_upgrade.repository.oders;



import Tendry.e_upgrade.models.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public abstract class GenericDAO<C> {
    private Connection connection;

    public GenericDAO(Connection connection){
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public abstract void insert(Order toInsert) throws SQLException;

    public abstract List<Order> findAllOrders() throws SQLException;

    public abstract Optional<Order> findOrderById(int id) throws SQLException;

    public abstract void delete(int id) throws SQLException;
}

