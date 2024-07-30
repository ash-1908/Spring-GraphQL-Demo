package com.ash.graphql_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int stock;
    private String category;
    private String name;

    public ProductCatalog() {
    }

    public ProductCatalog(int stock, String category, String name) {
        this.stock = stock;
        this.category = category;
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
