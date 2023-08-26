package Tendry.e_upgrade.repository.user;


import Tendry.e_upgrade.models.User;

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

    public abstract void insert(User toInsert) throws SQLException;

    public abstract List<User> findAllUser() throws SQLException;

    public abstract Optional<User> findUserById(int id) throws SQLException;
    public abstract void delete(int id) throws SQLException;
}
