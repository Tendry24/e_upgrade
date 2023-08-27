package Tendry.e_upgrade.controller;

import Tendry.e_upgrade.models.Product;
import Tendry.e_upgrade.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    @GetMapping
    public List<Product> getAllProducts(){
            return service.findAllProducts();
        }

    @GetMapping("/{id}")
    public Optional<Product> findProductById(@PathVariable int id){
        return service.findProductById(id);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product ) {
        return service.insert(product);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int id , HttpStatus done , HttpStatus fail) {
        Boolean deletedProduct = service.delete(id);

        if (deletedProduct != null && deletedProduct.booleanValue()) {
            return new ResponseEntity<>( done.OK);
        } else {
            return new ResponseEntity<>(fail.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        updatedProduct.setId(id);
        Product updated = service.update(updatedProduct);

        if (updated != null) {
            return new ResponseEntity<>(id + " has been updated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
