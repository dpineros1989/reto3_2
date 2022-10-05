package com.usa.g14.reto3.Controlador;

import com.usa.g14.reto3.Modelo.Cabin;
import com.usa.g14.reto3.Servicio.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/Cabin")

public class CabinControlador {
    @Autowired
    private CabinService cabinService;
    @GetMapping("/all")
    public List<Cabin> getAll(){
        return cabinService.getAll();
    }



    @PostMapping("/save")
    public Cabin save(@RequestBody Cabin p){
        return cabinService.save(p);

    }
}
