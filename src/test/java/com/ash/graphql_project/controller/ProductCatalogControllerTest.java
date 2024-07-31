package com.ash.graphql_project.controller;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import com.ash.graphql_project.entity.ProductCatalog;
import com.ash.graphql_project.service.ProductCatalogService;

@GraphQlTest(ProductCatalogController.class)
public class ProductCatalogControllerTest {

	@Autowired
	private GraphQlTester tester;

	@MockBean
	private ProductCatalogService productCatalogService;

	@Test
	public void testGetProductCatalogShouldReturnProductCatalog() {
		Mockito.when(productCatalogService.getProductCatalog(Mockito.anyInt())).thenReturn(new ProductCatalog());

		String document = """
				query GetProductCatalog {
				    getProductCatalog(id: 1) {
				        id
				        stock
				        category
				        name
				    }
				}
				""";
		tester.document(document).execute().path("getProductCatalog").entity(ProductCatalog.class);
	}

	@Test
	public void testGetAllProductCatalogsShouldReturnProductCatalogsList() {
		Mockito.when(productCatalogService.getAllProductCatalogs()).thenReturn(new ArrayList<ProductCatalog>());

		String document = """
				query GetAllProductCatalogs {
				    getAllProductCatalogs {
				        id
				        stock
				        category
				        name
				    }
				}
				""";

		tester.document(document).execute().path("getAllProductCatalogs").entityList(ProductCatalog.class);
	}

	@Test
	public void testAddStockShouldReturnProductCatalogWithUpdatedStock() {
		Mockito.when(productCatalogService.addStock(Mockito.anyInt(), Mockito.eq(5)))
				.thenReturn(new ProductCatalog(1, 5, "category", "name"));

		String document = """
				mutation AddStock {
				    addStock(id: 2, stock: 5) {
				        id
				        stock
				        category
				        name
				    }
				}
				""";

		tester.document(document).execute().path("addStock").entity(ProductCatalog.class);
	}

	@Test
	public void testAddProductCatalogShouldReturnProductCatalog() {
		Mockito.when(productCatalogService.addProductCatalog(Mockito.any())).thenReturn(new ProductCatalog());

		String document = """
				mutation AddProductCatalog {
				    addProductCatalog(product: { stock: 2, category: "w", name: "w" }) {
				        id
				        stock
				        category
				        name
				    }
				}
				""";

		tester.document(document).execute().path("addProductCatalog").entity(ProductCatalog.class);
	}
}
