package com.example.session_cookie.controller;

import com.example.session_cookie.dto.CartDto;
import com.example.session_cookie.dto.ProductDto;
import com.example.session_cookie.model.Product;
import com.example.session_cookie.service.CloudinaryService;
import com.example.session_cookie.service.IProductService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IProductService productService;
    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping("")
    public String showProduct(@RequestParam(required = false, defaultValue = "")
                              String name, Model model,
                              @PageableDefault(size = 5)
                              Pageable pageable) {
        Page<Product> products = productService.showProductPage(name, pageable);
        model.addAttribute("product", products);
        return "/views/product/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("create", new Product());
        return "/views/product/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute ProductDto productDto, @RequestParam("file") MultipartFile file) {
        try {
            String img = cloudinaryService.uploadImage(file);
            productDto.setImg(img);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        productService.addProduct(productDto);
        return "redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public String detailProduct(@PathVariable("id") long id, HttpServletResponse httpServletResponse, Model model) {
        Cookie cookie = new Cookie("idProduct", id + "");// tạo cookie
        cookie.setMaxAge(1 * 24 * 60 * 60);//thời gian tồn tại trong 1 ngày
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
        Product product = productService.findById(id);
        model.addAttribute("detail", product);
        return "/views/product/detail";
    }

    @GetMapping("/shopping/{id}")
    public String shoppingCart(@PathVariable("id") long id, @SessionAttribute("cart") CartDto cart) {
        Product product = productService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("/delete/{id}")
    public String deleteShopping(@PathVariable("id") long id,@SessionAttribute("cart") CartDto cart){
        cart.deleteProduct(id);
        return "redirect:/cart";
    }

}
