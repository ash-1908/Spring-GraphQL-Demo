package com.ash.graphql_project.controller;

import com.ash.graphql_project.entity.ProductCatalog;
import com.ash.graphql_project.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductCatalogController {
    @Autowired
    private ProductCatalogService productCatalogService;

    @QueryMapping
    public ProductCatalog getProduct(@Argument int id) {
        return productCatalogService.getProduct(id);
    }

    @QueryMapping
    public List<ProductCatalog> getAllProducts() {
        return productCatalogService.getAllProducts();
    }

    @MutationMapping
    public ProductCatalog addNewStock(@Argument int id, @Argument int stock) {
        return productCatalogService.addStock(id, stock);
    }

    @MutationMapping
    public ProductCatalog addNewProduct(@Argument ProductCatalog product) {
        return productCatalogService.addProduct(product);
    }
}