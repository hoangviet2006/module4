package com.example.session_cookie.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer value = productMap.get(productDto);
            productMap.replace(productDto, value + 1); // đã có sản phẩm thì tăng số lượng lên 1
        } else {
            productMap.put(productDto, 1); // chưa  có sản phẩm số lượng =1
        }
    }

    public boolean deleteProduct(long id){
        ProductDto productDto =null;
        for (ProductDto productDto1: productMap.keySet()){
            if (productDto1.getId()==id){
                productDto=productDto1;
               break;
            }
        }
        if (productDto!=null){
            productMap.remove(productDto);
            return true;
        }
        return false;
    }
}
