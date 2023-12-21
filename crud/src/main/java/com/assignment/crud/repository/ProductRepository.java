package com.assignment.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.crud.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContains(String name);
}
