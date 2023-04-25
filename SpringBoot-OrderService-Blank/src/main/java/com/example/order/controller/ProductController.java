package com.example.order.controller;

import com.example.order.model.order.OrderProductForm;
import com.example.order.model.product.Product;
import com.example.order.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RequestMapping("product")
@Controller
public class ProductController {

    private final ProductRepository productRepository;

    // 상품 목록
    @GetMapping("products")
    public String list() {
        return "/product/productList";
    }

    // 상품 상세 페이지
    @GetMapping("productInfo")
    public String itemInfo() {
        return "/product/productInfo";
    }
}
