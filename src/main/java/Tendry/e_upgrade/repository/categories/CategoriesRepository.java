package Tendry.e_upgrade.repository.categories;

import Tendry.e_upgrade.models.Categories;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                    Categories categories = extractTodoFromResultSet(resultSet);
                    categorie.add(categories);
                }
            }
            return categorie;
    }


    @Override
    public void insert(Categories toInsert) throws SQLException {

    }


    @Override
    public Optional<Categories> findById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    private Categories extractTodoFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        return new Categories(id, name);
    }
}
