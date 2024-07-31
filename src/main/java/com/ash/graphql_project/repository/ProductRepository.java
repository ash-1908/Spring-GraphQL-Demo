package com.ash.graphql_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ash.graphql_project.entity.ProductCatalog;

@Repository
public interface ProductRepository extends JpaRepository<ProductCatalog, Integer> {
}
