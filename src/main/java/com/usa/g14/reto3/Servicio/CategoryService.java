package com.usa.g14.reto3.Servicio;

import com.usa.g14.reto3.Modelo.Cabin;
import com.usa.g14.reto3.Modelo.Category;
import com.usa.g14.reto3.Repositorio.cabinRepositorio;
import com.usa.g14.reto3.Repositorio.categoryRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private categoryRepositorio CategoryRepositorio;
    public List<Category> getAll() {
        return CategoryRepositorio.getAll();
    }
    public Optional<Category> getCategory(int id) {
        return CategoryRepositorio.getCategory(id);
    }
    public Category save(Category p) {
        if (p.getId() == null) {
            return CategoryRepositorio.save(p);
        } else {
            Optional<Category> e = CategoryRepositorio.getCategory(p.getId());
            if (e.isPresent()) {
                return p;
            } else {
                return CategoryRepositorio.save(p);
            }


        }

    }

    public Category update(Category p) {
        if (p.getId() != null) {
            Optional<Category> q = CategoryRepositorio.getCategory(p.getId());
            if (q.isPresent()) {
                if (p.getName() != null) {
                    q.get().setName(p.getName());
                }
               CategoryRepositorio.save(q.get());
                return q.get();

            } else {
                return p;
            }
        }else{
            return p;
        }

    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Category> p = CategoryRepositorio.getCategory(id);
        if(p.isPresent()){
            CategoryRepositorio.delete(p.get());
            flag=true;
        }
        return flag;
    }

}
