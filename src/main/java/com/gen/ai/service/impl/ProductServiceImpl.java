package com.gen.ai.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gen.ai.dto.ProductDto;
import com.gen.ai.entity.Product;
import com.gen.ai.exception.InsufficientStockException;
import com.gen.ai.exception.ProductNotFoundException;
import com.gen.ai.repository.ProductRepository;
import com.gen.ai.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

        return convertToDto(product);
    }

    @Override
    public void addProduct(ProductDto productDto) {
        Product product = convertToEntity(productDto);
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long productId, ProductDto productDto) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

        existingProduct.setName(productDto.getName());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setStockQuantity(productDto.getStockQuantity());

        productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    // Additional methods as needed

    private ProductDto convertToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setStockQuantity(product.getStockQuantity());
        return productDto;
    }

    private Product convertToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setStockQuantity(productDto.getStockQuantity());
        return product;
    }

	@Override
	public void decreaseStockQuantity(Long productId, int quantity) {
		Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));

        int currentStock = product.getStockQuantity();
        if (currentStock >= quantity) {
            int newStock = currentStock - quantity;
            product.setStockQuantity(newStock);
            productRepository.save(product);
        } else {
            throw new InsufficientStockException("Insufficient stock for product with id: " + productId);
        }
		
	}

	@Override
	public void increaseStockQuantity(Long productId, int quantity) {
		Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));

        int currentStock = product.getStockQuantity();
        int newStock = currentStock + quantity;
        product.setStockQuantity(newStock);
        productRepository.save(product);
	}
}
