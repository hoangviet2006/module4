package com.example.session_cookie.service;

import com.example.session_cookie.dto.ProductDto;
import com.example.session_cookie.model.Product;
import com.example.session_cookie.repository.IProductRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Page<Product> showProductPage(String name, Pageable pageable) {
        return productRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    @Override
    public void addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setCode(productDto.getCode());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImg(productDto.getImg());
        product.setQuantity(productDto.getQuantity());
        productRepository.save(product);
    }

    @Override
    public boolean updateProduct(long id, ProductDto productDto) {
        Product product = productRepository.findById(id);
        if (product != null) {
            product.setCode(productDto.getCode());
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setImg(productDto.getImg());
            product.setQuantity(productDto.getQuantity());
            productRepository.save(product);
        }
        return true;
    }


    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }
}
