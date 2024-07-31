package com.ash.graphql_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ash.graphql_project.dto.ProductCatalogDTO;
import com.ash.graphql_project.entity.ProductCatalog;
import com.ash.graphql_project.service.ProductCatalogService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Controller
public class ProductCatalogController {
	@Autowired
	private ProductCatalogService productCatalogService;

	@QueryMapping
	public ProductCatalog getProduct(@Positive @Argument int id) {
		return productCatalogService.getProduct(id);
	}

	@QueryMapping
	public List<ProductCatalog> getAllProducts() {
		return productCatalogService.getAllProducts();
	}

	@MutationMapping
	public ProductCatalog addNewStock(@Positive @Argument int id, @PositiveOrZero @Argument int stock) {
		return productCatalogService.addStock(id, stock);
	}

	@MutationMapping
	public ProductCatalog addNewProduct(@Valid @Argument ProductCatalogDTO product) {
		return productCatalogService.addProduct(product);
	}
}