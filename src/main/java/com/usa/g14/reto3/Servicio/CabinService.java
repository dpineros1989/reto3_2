package com.usa.g14.reto3.Servicio;

import com.usa.g14.reto3.Interfaces.CabinInterface;
import com.usa.g14.reto3.Interfaces.CategoryInterface;
import com.usa.g14.reto3.Modelo.Cabin;
import com.usa.g14.reto3.Repositorio.cabinRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabinService {

    @Autowired
    private cabinRepositorio CabinRepositorio;

    public List<Cabin> getAll() {
        return CabinRepositorio.getAll();
    }

    public Optional<Cabin> getCabin(int id) {
        return CabinRepositorio.getCabin(id);
    }

    public Cabin save(Cabin p) {
        if (p.getId() == null) {
            return CabinRepositorio.save(p);
        } else {
            Optional<Cabin> e = CabinRepositorio.getCabin(p.getId());
            if (e.isPresent()) {
                return p;
            } else {
                return CabinRepositorio.save(p);
            }


        }

    }

    public Cabin update(Cabin p) {
        if (p.getId() != null) {
            Optional<Cabin> q = CabinRepositorio.getCabin(p.getId());
            if (q.isPresent()) {
                if (p.getName() != null) {
                    q.get().setName(p.getName());
                }
                if (p.getBrand() != null) {
                    q.get().setBrand(p.getBrand());
                }
                if (p.getRooms() != null) {
                    q.get().setRooms(p.getRooms());
                }
                if (p.getCategory() != null) {
                    q.get().setCategory(p.getCategory());
                }
                if (p.getDescription() != null) {
                    q.get().setDescription(p.getDescription());
                }
                CabinRepositorio.save(q.get());
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
                Optional<Cabin> p =CabinRepositorio.getCabin(id);
                if(p.isPresent()){
                    CabinRepositorio.delete(p.get());
                    flag=true;
                }
                return flag;
    }


}
