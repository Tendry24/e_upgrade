package Tendry.e_upgrade.controller;

import Tendry.e_upgrade.models.Categories;
import Tendry.e_upgrade.services.CategoriesService;
import lombok.AllArgsConstructor;
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

}