package Tendry.e_upgrade.controller;

import Tendry.e_upgrade.models.Categories;
import Tendry.e_upgrade.services.CategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CategoriesController {

        private CategoriesService service;

        @GetMapping("/allcategories")
        public List<Categories> getAllcat() {
            return service.findAllCategories();
        }

        @GetMapping("/Categories/{id}")
        public Optional<Categories> getById(@PathVariable int id){
            return service.findCategoriesById(id);
        }

        @PostMapping("/addcategory")
        public Categories addCategory(@RequestBody Categories category ) {
            return service.insert(category);
        }

        @PutMapping("/updatecategory/{id}")
        public ResponseEntity<String> updateCategory(@PathVariable int id, @RequestBody Categories updatedCategory) {
            updatedCategory.setId(id);
            Categories updated = service.update(updatedCategory);

            if (updated != null) {
                return new ResponseEntity<>("Category with ID " + id + " has been updated.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Category with ID " + id + " not found.", HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/deletecat/{id}")
        public ResponseEntity<String> deleteCategoryById(@PathVariable int id , HttpStatus done , HttpStatus fail) {
            Optional<Categories> deletedCategory = service.delete(id);

            if (deletedCategory.isPresent()) {
                return new ResponseEntity<>( done.OK);
            } else {
                return new ResponseEntity<>(fail.NOT_FOUND);
            }
        }
}