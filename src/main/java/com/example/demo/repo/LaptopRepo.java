package com.example.demo.repo;

import com.example.demo.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<Laptop, Integer> {

}
