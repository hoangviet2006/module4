package com.example.bai_tap_jpa.controller;

import com.example.bai_tap_jpa.model.Product;
import com.example.bai_tap_jpa.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String getProduct(Model model) {
        List<Product> productList = productService.getAll();
        model.addAttribute("list", productList);
        return "/listProduct";
    }

    @GetMapping("create")
    public String formCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/createProduct";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Product product) {
        int id = productService.getAll().size() + 1;
        product.setId(id);
        productService.addProduct(product);
        return "redirect:/product";
    }

    @GetMapping("update")
    public String formUpdate(Model model, @RequestParam("id") int id) {
        Product product = productService.findId(id);
        model.addAttribute("findId", product);
        return "/updateProduct";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Product product) {
        productService.updateProduct(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }

    @PostMapping("search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Product> productList = productService.searchProduct(name);
        model.addAttribute("list",productList);
        return "/listProduct";
    }
}
