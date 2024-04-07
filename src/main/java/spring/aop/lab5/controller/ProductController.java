package spring.aop.lab5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.aop.lab5.aop.ExecutionTime;
import spring.aop.lab5.entity.Product;
import spring.aop.lab5.service.ProductService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    @ExecutionTime
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @ExecutionTime
    @PostMapping
    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }
}
