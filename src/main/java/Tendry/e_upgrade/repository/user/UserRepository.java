package Tendry.e_upgrade.repository.user;


import Tendry.e_upgrade.models.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository extends GenericDAO{
    public UserRepository(Connection connection) {
        super(connection);
    }

    @Override
    public void insert(User toInsert) throws SQLException {
        String sql = "INSERT INTO \"user\"(id,name,email,password,adress) VALUES (?,?,?,?,?)";
        try(
                PreparedStatement statement = getConnection().prepareStatement(sql)
        ){
            statement.setInt(1,toInsert.getId());
            statement.setString(2,toInsert.getName());
            statement.setString(3,toInsert.getEmail());
            statement.setString(4,toInsert.getPassword());
            statement.setString(5,toInsert.getAdress());

            statement.executeUpdate();
        }
    }

    @Override
    public List<User> findAllUser() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM \"user\"";
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                User alluser = extractUserFromResultSet(resultSet);
                users.add(alluser);
            }
        }
        return users;
    }

    @Override
    public Optional<User> findUserById(int id) throws SQLException {
        String sql = "SELECT * FROM \"user\" WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return Optional.of(extractUserFromResultSet(resultSet));
                }
            }
            return Optional.empty();
        }
    }

    public List<User> findUserbyName(String name) throws  SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM \"user\" WHERE name ILIKE ?;";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, "%"+name+"%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User alluser = extractUserFromResultSet(resultSet);
                    users.add(alluser);
                }
            }
            return users;
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM \"user\" WHERE id = ?";
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


    public void update(User updatedUser) throws SQLException {
        String sql = "UPDATE \"user\" SET name=?,email=?,password=?,adress=? WHERE id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, updatedUser.getId());
            statement.setString(2, updatedUser.getName());
            statement.setString(3,updatedUser.getEmail());
            statement.setString(4,updatedUser.getPassword());
            statement.setString(5,updatedUser.getAdress());

            statement.executeUpdate();
        }
    }



    private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String adress = resultSet.getString("adress");


        return new User(id, name,email,password,adress);
    }
}
