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
@RequestMapping("/categories")
public class CategoriesController {

        private CategoriesService service;

        @GetMapping
        public List<Categories> getAllcat() {
            return service.findAllCategories();
        }

        @GetMapping("/{id}")
        public Optional<Categories> getById(@PathVariable int id){
            return service.findCategoriesById(id);
        }

        @GetMapping("/name/{name}")
        public List<Categories> getByname(@PathVariable String name){
            return service.findCategorieByName(name);
        }

        @PostMapping("/add")
        public Categories addCategory(@RequestBody Categories category ) {
            Categories addedCategory =  service.insert(category);
            return new ResponseEntity<>(addedCategory, HttpStatus.CREATED).getBody();
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<String> updateCategory(@PathVariable int id, @RequestBody Categories updatedCategory) {
            updatedCategory.setId(id);
            Categories updated = service.update(updatedCategory);

            if (updated != null) {
                return new ResponseEntity<>("Category with ID " + id + " has been updated.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Category with ID " + id + " not found.", HttpStatus.NOT_FOUND);
            }
        }
        
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteCategoriesById(@PathVariable int id) {
            boolean deleted = service.delete(id);
            if (deleted) {
                return new ResponseEntity<>("Category with id " + id + " deleted.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Category with id " + id + " not found.", HttpStatus.NOT_FOUND);
            }
        }
}