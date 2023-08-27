package Tendry.e_upgrade.repository.categories;


import Tendry.e_upgrade.models.Categories;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.sql.SQLException;



public abstract class GenericDAO<C> {
    private Connection connection;

    public GenericDAO(Connection connection){
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public abstract void insert(Categories toInsert) throws SQLException;

    public abstract List<Categories> findAll() throws SQLException;

    public abstract Optional<Categories> findById(int id) throws SQLException;
    public abstract void delete(int id) throws SQLException;
}

