package com.example.demo.controller;

import com.example.demo.dao.LaptopDao;
import com.example.demo.entity.Laptop;
import com.example.demo.service.LaptopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("laptops/")

public class LaptopController {

    private final LaptopDao dao;
    private final LaptopService service;

    @GetMapping("getAllLaptops")
    public List<Laptop> getAllLaptops(){
        return service.getAllLaptops();
    }

    @GetMapping("getLaptopById:{id}")
    public Optional<Laptop> getLaptopById(@PathVariable Integer id){
        return service.getLaptopById(id);
    }

    @PostMapping("insertLaptop")
    public ResponseEntity<String> insertLaptop(@RequestBody Laptop laptop){
        service.saveLaptop(laptop);
        return ResponseEntity.ok("Laptop saved");
    }

    @PutMapping("updateLaptop")
    public void updateLaptop(@RequestParam Integer id, @RequestBody Laptop laptop){
        dao.updateLaptop(id, laptop);

    }
    @DeleteMapping("deleteLaptop/{laptopId}")
    public void deleteLaptop(@PathVariable Integer laptopId){
        service.deleteLaptop(laptopId);
    }


}
