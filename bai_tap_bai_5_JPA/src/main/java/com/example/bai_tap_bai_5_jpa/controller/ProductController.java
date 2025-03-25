package com.example.bai_tap_bai_5_jpa.controller;

import com.example.bai_tap_bai_5_jpa.model.Product;
import com.example.bai_tap_bai_5_jpa.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("")
    public String getProduct(Model model) {
        List<Product> productList = productService.getAll();
        model.addAttribute("list",productList);
        return "/listProduct";
    }
}
