package Tendry.e_upgrade.repository.product;


import Tendry.e_upgrade.models.Product;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository extends GenericDAO {
    public ProductRepository(Connection connection) {
        super(connection);
    }

    @Override
    public void insert(Product toInsert) throws SQLException {

    }

    @Override
    public List<Product> findAllProduct() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Product newProduct = extractTodoFromResultSet(resultSet);
                products.add(newProduct);
            }
        }
        return products;
    }

    @Override
    public Optional<Product> findProductById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    private Product extractTodoFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        int categories_id = resultSet.getInt("categories_id");
        Double price = resultSet.getDouble("price");
        int stock_quantity = resultSet.getInt("stock_quantity");


        return new Product(id, name,description,categories_id,price,stock_quantity);
    }
}
