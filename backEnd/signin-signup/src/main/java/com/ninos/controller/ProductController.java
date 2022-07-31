package com.ninos.controller;

import com.ninos.dto.ProductDTO;
import com.ninos.model.Product;
import com.ninos.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;


    // http://localhost:8080/api/v1/products

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts(){
         return productService.findAllProducts();
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/forUser")
    public String forUser(){
         return "this is user only";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/forAdmin")
    public String forAdmin(){
        return "this is admin only";
    }



}
