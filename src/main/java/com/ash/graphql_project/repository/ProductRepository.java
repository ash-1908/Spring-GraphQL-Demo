package com.ash.graphql_project.repository;

import com.ash.graphql_project.entity.ProductCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductCatalog, Integer> {
}
