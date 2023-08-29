package Tendry.e_upgrade.services;

import Tendry.e_upgrade.models.Product;
import Tendry.e_upgrade.repository.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository product;
    public List<Product> findAllProducts(){
        try{
            return product.findAllProduct();
        }catch (SQLException e){
            throw new RuntimeException("Error");
        }
    }

    public Optional<Product> findProductById(int id){
        try{
            return product.findProductById(id);
        } catch (SQLException e){
            throw new RuntimeException("Error");
        }
    }


    public List<Product> findProductByName(String name){
        try{
            return product.findProductByName(name);
        } catch (SQLException e){
            throw new RuntimeException("Error");
        }
    }


    public Product insert(Product toInsert){
        try{
            this.product.insert(toInsert);
            return toInsert;
        } catch (SQLException e){
            throw new RuntimeException("Error");
        }
    }


    public Boolean delete(int toDelete){
        try {
            this.product.delete(toDelete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Product update(Product updatedProduct) {
        try {
            this.product.update(updatedProduct);
            return updatedProduct;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating Order");
        }
    }
}
