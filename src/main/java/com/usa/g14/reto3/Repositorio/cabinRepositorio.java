package com.usa.g14.reto3.Repositorio;

import com.usa.g14.reto3.Interfaces.CabinInterface;
import com.usa.g14.reto3.Modelo.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class cabinRepositorio {

    @Autowired
    private CabinInterface cabinInterface;

    public List<Cabin> getAll(){
        return (List<Cabin>) cabinInterface.findAll();
    }
    public Optional<Cabin> getCabin(int id){
        return cabinInterface.findById(id);
    }
    public Cabin save(Cabin p){
        return cabinInterface.save(p);
    }
    public void delete(Cabin p){
        cabinInterface.delete(p);
    }

}
