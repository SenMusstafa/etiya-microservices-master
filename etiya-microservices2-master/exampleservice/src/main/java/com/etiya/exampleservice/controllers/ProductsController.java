package com.etiya.exampleservice.controllers;


import com.etiya.exampleservice.business.ProductService;
import com.etiya.exampleservice.business.ProductServiceImpl;
import com.etiya.exampleservice.logging.DbLogger;
import com.etiya.exampleservice.logging.FileLogger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Ürün entitysi için endpoint kontrolü yapmak.
// Ürün entitysi için iş süreçlerini ilerletmek
@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    private ProductService productService;

    @PostMapping
    public void add() {
        productService.add(null);
    }
}
