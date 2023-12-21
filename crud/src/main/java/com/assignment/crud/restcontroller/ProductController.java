package com.assignment.crud.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.crud.entity.Product;
import com.assignment.crud.model.WebResponse;
import com.assignment.crud.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addproduct")
    public WebResponse<Product> addProduct(@RequestBody Product product) {
        return WebResponse.<Product>builder().data(service.saveProduct(product)).build();
    }

    @GetMapping("/products")
    public WebResponse<List<Product>> findAllProducts() {
        return WebResponse.<List<Product>>builder().data(service.getProducts()).build();
    
    }

    @GetMapping("/productbyid/{id}")
    public WebResponse<Product> findProductById(@PathVariable int id) {
        return WebResponse.<Product>builder().data(service.getProductById(id)).build();
    }

    @GetMapping("/product/")
    public WebResponse<List<Product>> findProductByName(@RequestParam String name) {
        return WebResponse.<List<Product>>builder().data(service.getProductByName(name)).build();
    }

    @PutMapping("/update/{id}")
    public WebResponse<Product> updateProduct(@PathVariable long id,
                                @RequestBody Product product) {
        return WebResponse.<Product>builder().data(service.updateProduct(id, product)).build();
    }

    @DeleteMapping("/delete/{id}")
    public WebResponse<String> deleteProduct(@PathVariable int id) {
        return WebResponse.<String>builder().data(service.deleteProduct(id)).build();
    }

    
}
