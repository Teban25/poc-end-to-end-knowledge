package com.davids.pocs.inventory.repository;

import com.davids.pocs.inventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
