package com.etiya.orderservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// BaseUrl
@FeignClient(name="product-service")
// DiscoveryServer'dan productService ismine sahip servisin bilgisini çeker
public interface ProductClient
{
    @GetMapping("/api/v1/products")
    Boolean getStockStatus(@RequestParam("productId") int productId);
}
