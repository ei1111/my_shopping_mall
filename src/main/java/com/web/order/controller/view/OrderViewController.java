package com.web.order.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderViewController {

    @GetMapping("/new")
    public String orderForm() {
        return "order/orderForm";
    }

    @GetMapping
    public String orderList() {
        return "order/orderList";
    }
}
