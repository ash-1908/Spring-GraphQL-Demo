package com.ash.graphql_project.service;

import com.ash.graphql_project.entity.ProductCatalog;
import com.ash.graphql_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCatalogService {
    @Autowired
    private ProductRepository productRepository;

    public ProductCatalog addProduct(ProductCatalog product) {
        //todo validate product
        ProductCatalog savedProduct = productRepository.save(product);
        //todo handle case for error while saving
        return savedProduct;
    }

    public ProductCatalog addStock(int id, int stockCount) {
        //todo validate stock count and id
        ProductCatalog product = productRepository.getById(id);
        //todo use recommended method
        product.setStock(stockCount);
        product = productRepository.save(product);
        //todo handle error while saving
        return product;
    }

    public ProductCatalog getProduct(int id) {
        return productRepository.getById(id);
    }

    public List<ProductCatalog> getAllProducts() {
        return productRepository.findAll();
    }
}
