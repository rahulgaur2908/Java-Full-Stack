package com.rahul.fullstack.service;

import com.rahul.fullstack.entity.ProductEntity;
import com.rahul.fullstack.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 1. Caches result under 'products' cache using 'id' as key.
    // Subsequent calls with the same ID hit Redis directly, skipping the database!
    @Cacheable(value = "products", key = "#id")
    public ProductEntity getProductById(Long id) {
        System.out.println("⚠️ Cache Miss! Fetching product ID " + id + " directly from Database...");
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    // 2. Automatically invalidates cached item when product is updated
    @CacheEvict(value = "products", key = "#id")
    public ProductEntity updateProduct(Long id, ProductEntity updatedProduct) {
        System.out.println("🔄 Updating Database & Evicting stale Redis cache for ID " + id);
        updatedProduct.setId(id);
        return productRepository.save(updatedProduct);
    }
}