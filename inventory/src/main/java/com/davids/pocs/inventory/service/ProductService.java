package com.davids.pocs.inventory.service;

import com.davids.pocs.inventory.model.Product;
import com.davids.pocs.inventory.repository.ProductRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private KafkaTemplate<String, String> kafkaTemplate;

    public ProductService(ProductRepository productRepository,
                          KafkaTemplate<String, String> kafkaTemplate) {
        this.productRepository = productRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        // kafka logic
        return savedProduct;
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found to be updated"));

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        if (product.getDescription() != null && Strings.isNotEmpty(product.getDescription())) {
            existingProduct.setDescription(product.getDescription());
        }

        Product updatedProduct = productRepository.save(existingProduct);
        // Kafka logic here
        return updatedProduct;
    }
}
