package com.example.bai_tap_bai_5_jpa.service;

import com.example.bai_tap_bai_5_jpa.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    boolean addProduct(Product product);
    boolean updateProduct(int id,Product product);
    boolean deleteProduct(int id);
    List<Product> searchProduct(String name);
    Product findId(int id);
}
