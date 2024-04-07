package spring.aop.lab5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.aop.lab5.entity.Product;
import spring.aop.lab5.repository.ActivityLogRepo;
import spring.aop.lab5.repository.ProductRepo;
import spring.aop.lab5.repository.ReviewRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;


    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }
}
