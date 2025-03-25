package com.example.bai_tap_jpa.repository;

import com.example.bai_tap_jpa.model.Product;
import com.example.bai_tap_jpa.repository.ProductRepository;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    boolean addProduct(Product product);
    boolean updateProduct(int id,Product product);
    boolean deleteProduct(int id);
    List<Product> searchProduct(String name);
    Product findId(int id);
}
