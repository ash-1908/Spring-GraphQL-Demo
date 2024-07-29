package com.ash.graphql_project.controller;

import com.ash.graphql_project.entity.ProductCatalog;
import com.ash.graphql_project.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductCatalogController {
    @Autowired
    private ProductCatalogService productCatalogService;

    @GetMapping
    public ProductCatalog getProduct(@RequestParam int id) {
        return productCatalogService.getProduct(id);
    }

    @GetMapping("/all")
    public List<ProductCatalog> getAllProducts() {
        return productCatalogService.getAllProducts();
    }

    @PostMapping("/addStock")
    public ProductCatalog addNewStock(@RequestParam int id, @RequestParam int stock) {
        return productCatalogService.addStock(id, stock);
    }

    @PostMapping("/addProduct")
    public ProductCatalog addNewProduct(@RequestBody ProductCatalog product) {
        return productCatalogService.addProduct(product);
    }
}
