package Tendry.e_upgrade.repository.categories;

import Tendry.e_upgrade.models.Categories;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoriesRepository extends GenericDAO{
    public CategoriesRepository(Connection connection) {
        super(connection);
    }

    @Override
    public List<Categories> findAll() throws SQLException {
            List<Categories> categorie = new ArrayList<>();
            String sql = "SELECT * FROM cat";

            try (Statement statement = getConnection().createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Categories categories = extractCategoriesFromResultSet(resultSet);
                    categorie.add(categories);
                }
            }
            return categorie;
    }

    @Override
    public Optional<Categories> findById(int id) throws SQLException {
        String sql = "SELECT * FROM cat WHERE id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    return Optional.of(extractCategoriesFromResultSet(resultSet));
                }
            }
            return Optional.empty();
        }
    }


    @Override
    public void insert(Categories toInsert) throws SQLException {
        String sql = "INSERT INTO cat(name) VALUES (?)";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)){
            //statement.setInt(1,toInsert.getId());
            statement.setString(1,toInsert.getName());

            statement.executeUpdate();
        }
    }


    public void update(Categories updatedCategory) throws SQLException {
        String sql = "UPDATE cat SET name = ? WHERE id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, updatedCategory.getName());
            statement.setInt(2, updatedCategory.getId());
            statement.executeUpdate();
        }
    }


    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM cat WHERE id = ?";
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

    private Categories extractCategoriesFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        return new Categories(id, name);
    }
}
