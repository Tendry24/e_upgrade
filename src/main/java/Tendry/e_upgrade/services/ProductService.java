package Tendry.e_upgrade.services;

import Tendry.e_upgrade.models.Product;
import Tendry.e_upgrade.repository.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

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
}
