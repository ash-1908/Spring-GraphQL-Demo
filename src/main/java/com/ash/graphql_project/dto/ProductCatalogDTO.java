package com.ash.graphql_project.dto;

import com.ash.graphql_project.entity.ProductCatalog;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCatalogDTO {
	@Positive
	private int stock;
	@NotBlank
	private String category;
	@NotBlank
	private String name;

	public ProductCatalog mapToEntity() {
		return new ProductCatalog(this.stock, this.category, this.name);
	}
}
