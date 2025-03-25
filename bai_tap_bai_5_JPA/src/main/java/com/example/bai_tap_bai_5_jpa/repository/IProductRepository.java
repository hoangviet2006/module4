package com.example.bai_tap_bai_5_jpa.repository;

import com.example.bai_tap_bai_5_jpa.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    boolean addProduct(Product product);
    boolean updateProduct(int id,Product product);
    boolean deleteProduct(int id);
    List<Product> searchProduct(String name);
}
