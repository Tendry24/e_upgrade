package Tendry.e_upgrade.controller;

import Tendry.e_upgrade.models.Product;
import Tendry.e_upgrade.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductService service;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
            return service.findAllProducts();
        }
}
