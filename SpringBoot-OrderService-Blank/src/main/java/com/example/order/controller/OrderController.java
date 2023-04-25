package com.example.order.controller;

import com.example.order.model.order.OrderProductForm;
import com.example.order.model.product.Product;
import com.example.order.model.order.MyOrderDTO;
import com.example.order.model.order.Order;
import com.example.order.model.member.Member;
import com.example.order.repository.ProductRepository;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("order")
@RequiredArgsConstructor
@Controller
public class OrderController {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    // 상품 주문하기
    @PostMapping("orderProduct")
    public String order() {
        return "redirect:/product/products";
    }

    // 내가 주문한 상품 목록
    @GetMapping("myOrders")
    public String myOrders() {
        return "order/myOrders";
    }

    // 주문 상세정보
    @GetMapping("orderInfo")
    public String orderInfo() {
        return "order/orderInfo";
    }

    // 주문 취소
    @GetMapping("withdrawOrder")
    public String withdrawOrder() {
        return "redirect:/order/myOrders";
    }
}
