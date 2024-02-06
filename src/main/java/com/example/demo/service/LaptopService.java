package com.example.demo.service;

import com.example.demo.entity.Laptop;
import com.example.demo.repo.LaptopRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class LaptopService {

    private final LaptopRepo repo;

    public void saveLaptop(Laptop laptopRequest){

        Laptop laptop = new Laptop();

        laptop.setPrice(laptopRequest.getPrice());
        laptop.setBrand(laptopRequest.getBrand());
        laptop.setModel(laptopRequest.getModel());
        laptop.setLaptopPhoto(laptopRequest.getLaptopPhoto());

        repo.save(laptop);
    }

    public List<Laptop> getAllLaptops(){
        return repo.findAll();
    }

    public Optional<Laptop> getLaptopById(Integer id){
        return repo.findById(id);
    }

    public void deleteLaptop(Integer laptopId){
        repo.deleteById(laptopId);
    }

}
