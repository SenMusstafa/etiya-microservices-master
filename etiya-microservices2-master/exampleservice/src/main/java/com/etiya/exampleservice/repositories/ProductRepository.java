package com.etiya.exampleservice.repositories;

import com.etiya.exampleservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Optional<Product> findProductByName(String name);
}
