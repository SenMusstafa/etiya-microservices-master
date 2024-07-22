package etiya.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/products")
@RestController
public class ProductsController {
    @GetMapping
    public boolean checkStock(@RequestParam int productId) {
        System.out.println("İstek geldi.");
        try{
            Thread.sleep(3000);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        if(productId>5)
            return false;
        return true;
    }
}
