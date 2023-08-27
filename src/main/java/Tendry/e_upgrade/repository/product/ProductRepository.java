package Tendry.e_upgrade.repository.product;


import Tendry.e_upgrade.models.Product;
import Tendry.e_upgrade.models.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
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
        String sql = "INSERT INTO product(name,description,categories_id,price,stock_quantity)";
        try(
                PreparedStatement statement = getConnection().prepareStatement(sql)
        ){
            statement.setString(1,toInsert.getName());
            statement.setString(2,toInsert.getDescription());
            statement.setInt(3,toInsert.getCategories_id());
            statement.setDouble(4,toInsert.getPrice());
            statement.setInt(5,toInsert.getStock_quantity());

            statement.executeUpdate();
        }
    }

    @Override
    public List<Product> findAllProduct() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Product newProduct = extractProductFromResultSet(resultSet);
                products.add(newProduct);
            }
        }
        return products;
    }

    @Override
    public Optional<Product> findProductById(int id) throws SQLException {
        String sql = "SELECT * FROM \"product\" WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return Optional.of(extractProductFromResultSet(resultSet));
                }
            }
            return Optional.empty();
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM product WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println( id + " has been deleted.");
            } else {
                System.out.println(  id + "not found.");
            }
        }
        return false;
    }


    public void update(Product updatedProduct) throws SQLException {
        String sql = "UPDATE product SET name=?,description=?,categories_id=?,price=?,stock_quantity=? WHERE id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, updatedProduct.getId());
            statement.setString(2, updatedProduct.getName());
            statement.setString(3,updatedProduct.getDescription());
            statement.setInt(4,updatedProduct.getCategories_id());
            statement.setDouble(5,updatedProduct.getPrice());
            statement.setInt(6,updatedProduct.getCategories_id());

            statement.executeUpdate();
        }
    }

    public List<Product> findProductByName(String name) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM \"product\" WHERE name ILIKE ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, "%"+name+"%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Product prod = extractProductFromResultSet(resultSet);
                    products.add(prod);
                }
            }
            return products;
        }
    }

    private Product extractProductFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        int categories_id = resultSet.getInt("categories_id");
        Double price = resultSet.getDouble("price");
        int stock_quantity = resultSet.getInt("stock_quantity");


        return new Product(id, name,description,categories_id,price,stock_quantity);
    }
}
