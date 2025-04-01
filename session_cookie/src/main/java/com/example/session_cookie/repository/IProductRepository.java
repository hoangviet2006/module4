package com.example.session_cookie.repository;

import com.example.session_cookie.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Product findById(long id);
}
