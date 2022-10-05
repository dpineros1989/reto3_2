package com.usa.g14.reto3.Repositorio;

import com.usa.g14.reto3.Interfaces.CategoryInterface;
import com.usa.g14.reto3.Modelo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class categoryRepositorio {

    @Autowired
    private CategoryInterface categoryInterface;

    public List<Category> getAll(){
        return (List<Category>) categoryInterface.findAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryInterface.findById(id);
    }

    public Category save(Category c){
        return categoryInterface.save(c);
    }

    public void delete(Category c){
        categoryInterface.delete(c);
    }

}
