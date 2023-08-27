package Tendry.e_upgrade.services;


import Tendry.e_upgrade.models.Categories;
import Tendry.e_upgrade.repository.categories.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Service

public class CategoriesService {
    private CategoriesRepository categorie;

    public CategoriesService(CategoriesRepository categorie) {
        this.categorie = categorie;
    }

    public List<Categories> findAllCategories() {
        try {
            return categorie.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error");
        }
    }

    public Categories insert(Categories toInsert){
        try{
            this.categorie.insert(toInsert);
            return toInsert;
        } catch (SQLException e){
            throw new RuntimeException("Error");
        }
    }
}
