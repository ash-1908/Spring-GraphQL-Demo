package com.ash.graphql_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCatalog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int stock;
	private String category;
	private String name;

	public ProductCatalog(int stock, String category, String name) {
		this.stock = stock;
		this.category = category;
		this.name = name;
	}
}
