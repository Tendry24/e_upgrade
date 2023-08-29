package Tendry.e_upgrade.repository.product;

import Tendry.e_upgrade.models.Product;

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

    public abstract void insert(Product toInsert) throws SQLException;

    public abstract List<Product> findAllProduct() throws SQLException;

    public abstract Optional<Product> findProductById(int id) throws SQLException;

    public abstract boolean delete(int id) throws SQLException;
}
