package com.vera.springbootmall.service;

import com.vera.springbootmall.dto.ProductRequest;
import com.vera.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
