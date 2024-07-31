package com.ash.graphql_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ash.graphql_project.dto.ProductCatalogDTO;
import com.ash.graphql_project.entity.ProductCatalog;
import com.ash.graphql_project.repository.ProductRepository;

@Service
@Transactional
public class ProductCatalogService {
	@Autowired
	private ProductRepository productRepository;

	public ProductCatalog addProductCatalog(ProductCatalogDTO product) {
		return productRepository.save(product.mapToEntity());
	}

	public ProductCatalog addStock(int id, int newStock) {
		ProductCatalog product = productRepository.getReferenceById(id);
		int updatedStock = product.getStock() + newStock;
		product.setStock(updatedStock);
		return productRepository.save(product);
	}

	public ProductCatalog getProductCatalog(int id) {
		return productRepository.getReferenceById(id);
	}

	public List<ProductCatalog> getAllProductCatalogs() {
		return productRepository.findAll();
	}
}
