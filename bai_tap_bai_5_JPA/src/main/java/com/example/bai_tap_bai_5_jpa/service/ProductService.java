package com.example.bai_tap_bai_5_jpa.service;

import com.example.bai_tap_bai_5_jpa.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    private IProductService productService = new ProductService();
    @Override
    public List<Product> getAll() {
        return productService.getAll();
    }

    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(int id, Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public List<Product> searchProduct(String name) {
        return null;
    }

    @Override
    public Product findId(int id) {
        return null;
    }
}
