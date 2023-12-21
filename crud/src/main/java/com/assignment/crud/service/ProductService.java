package com.assignment.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.assignment.crud.entity.Product;
import com.assignment.crud.repository.ProductRepository;

@Service
public class ProductService {

     @Autowired
    private ProductRepository repository;

    @Autowired
    private ValidationService validationService;

    public Product saveProduct(Product product) {
        validationService.validate(product);

        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    public List<Product> getProductByName(String name) {
        return repository.findByNameContains(name);
    }

    public String deleteProduct(long id) {
        repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        repository.deleteById(id);
        return "Succes removed product !";
    }

    public Product updateProduct(long id, Product product) {
        validationService.validate(product);

        Product existingProduct = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setQty(product.getQty());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

}
