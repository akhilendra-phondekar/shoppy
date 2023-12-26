package com.gen.ai.service;

import java.util.List;

import com.gen.ai.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getAllProducts();

    ProductDto getProductById(Long productId);

    void addProduct(ProductDto productDto);

    void updateProduct(Long productId, ProductDto productDto);

    void deleteProduct(Long productId);

	void decreaseStockQuantity(Long productId, int quantity);

	void increaseStockQuantity(Long productId, int quantity);

}
