package com.assignment.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Dashboard {

    @GetMapping("/dashboard")
    public String dashboard(){
        return "/dashboard/dashboard";
    }

    @GetMapping("/products")
    public String product(){
        return "/dashboard/products";
    }

    @GetMapping("/addproduct")
    public String add(){
        return "/dashboard/addProduct";
    }

    @GetMapping("/home")
    public String home(){
        return "/dashboard/home";
    }

}
