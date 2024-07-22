package com.etiya.exampleservice.business;

import com.etiya.exampleservice.dtos.AddProductRequest;

public interface ProductService {
    /**
     * Ürün ekleme işlemini gerçekleştiren fonksiyon.
     * @param request Ürün eklenmesi için gerekli bilgileri içeren nesne.
     */
    void add(AddProductRequest request);
}
