package com.etiya.exampleservice.business;

import com.etiya.exampleservice.dtos.*;
import com.etiya.exampleservice.entities.Product;
import com.etiya.exampleservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService
{

    // Java, C#, JS

    // Değişkenler => productService, product =>  camelCase
    // Fonksiyonlar => addProduct(), add(), updateData() => camelCase
    // Class Tanım => ProductService, Product => UpperCamelCase
    // Sabitler (Constant) => PI, MAX_SIZE => UPPER_CASE
    // Package => com.etiya.example
    // Generics => T (type), E (element), K (key), V (value), ID

    // Tutarlılık

    private final ProductRepository productRepository;

    /**
     * @param request
     */
    public void add(AddProductRequest request) {
        if (productRepository.findProductByName(request.getName()).isPresent()) {
            throw new RuntimeException("");
        }
        Product product = new Product();
        product.setName(request.getName()); 
        productRepository.save(product);
    }

    /**
     * Kullanıcı adını alarak bu kullanıcı adını verify eder.
     *
     * @param username verify edilecek username değeri.
     * @return verify işleminin gerçekleşip gerçekleşmediği bilgisini döndürür.
     */
    public boolean verify(String username) {
        return true;
    }
}
