package com.etiya.exampleservice.business;

import com.etiya.exampleservice.dtos.AddProductRequest;
import com.etiya.exampleservice.entities.Product;
import com.etiya.exampleservice.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {
    private ProductServiceImpl productService;

    @Mock // => Kalıp,Taklit
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    void addWithExistingNameShouldThrowException()
    {
        Product product = new Product(1,"Laptop");

        Mockito.when(productRepository.findProductByName("Laptop")).thenReturn(Optional.of(product));

        AddProductRequest addProductRequest = new AddProductRequest("Laptop");

        assertThrows(RuntimeException.class, () -> {
            productService.add(addProductRequest);
        });
    }

    @Test
    void add() {
        Mockito.when(productRepository.findProductByName("Laptop")).thenReturn(Optional.empty());

        AddProductRequest addProductRequest = new AddProductRequest("Laptop");

        productService.add(addProductRequest);
        productService.verify("");
        assert true;
    }
}