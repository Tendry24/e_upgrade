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

    public Optional<Categories> findCategoriesById(int id){
        try{
            return categorie.findById(id);
        } catch (SQLException e){
            throw new RuntimeException("Error");
        }
    }

    public List<Categories> findCategorieByName(String name){
        try {
            return categorie.findCategorieByName(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
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


    public Categories update(Categories updatedCategory) {
        try {
            this.categorie.update(updatedCategory);
            return updatedCategory;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating category");
        }
    }


    public boolean delete(int id) {
        try {
            categorie.delete(id);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
