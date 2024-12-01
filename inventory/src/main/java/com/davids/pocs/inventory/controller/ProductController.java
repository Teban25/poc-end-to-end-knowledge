package com.davids.pocs.inventory.controller;

import com.davids.pocs.inventory.controller.response.ApiResponse;
import com.davids.pocs.inventory.model.Product;
import com.davids.pocs.inventory.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/sku")
    public ApiResponse<Product> getProductBySku(@RequestParam String sku) {
        Product productFound = productService.getProductBySku(sku);
        return new ApiResponse<>(HttpStatus.OK.value(),"Product retrieved successfully", productFound);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
}
