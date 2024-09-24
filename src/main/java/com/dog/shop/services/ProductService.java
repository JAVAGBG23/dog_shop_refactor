package com.dog.shop.services;

import com.dog.shop.factory.ProductFactory;
import com.dog.shop.factory.ProductFactoryProvider;
import com.dog.shop.models.Product;
import com.dog.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {
   // innehålla basic crud operationer
    private final ProductRepository productRepository;
    private final ProductFactoryProvider productFactoryProvider;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductFactoryProvider productFactoryProvider) {
        this.productRepository = productRepository;
        this.productFactoryProvider = productFactoryProvider;
    }

    public Product createProduct(String productType, Map<String, Object> productDetails) {
        // hämta rätt factory baserat på productType
        ProductFactory productFactory = productFactoryProvider.getFactory(productType);

        // skapa produkt genom factory
        Product product = productFactory.createProduct(productDetails);

        return productRepository.save(product);
    }

   public List<Product> getAllProducts() {
        return productRepository.findAll();
   }

   public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
   }
}
































