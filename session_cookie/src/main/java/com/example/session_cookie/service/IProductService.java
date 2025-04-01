package com.example.session_cookie.service;

import com.example.session_cookie.dto.ProductDto;
import com.example.session_cookie.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService  {
    Page<Product> showProductPage(String name, Pageable pageable);
    void addProduct(ProductDto productDto);
    boolean updateProduct(long id,ProductDto productDto);
    Product findById(long id);
}
