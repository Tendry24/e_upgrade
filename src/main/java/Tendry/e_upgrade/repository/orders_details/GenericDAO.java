package Tendry.e_upgrade.repository.orders_details;


import Tendry.e_upgrade.models.Order_details;

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

    public abstract void insert(Order_details toInsert) throws SQLException;

    public abstract List<Order_details> findAll() throws SQLException;

    public abstract Optional<Order_details> findById(int id) throws SQLException;
    public abstract void delete(int id) throws SQLException;
}
