package com.vera.springbootmall.service;

import com.vera.springbootmall.dto.ProductQueryParams;
import com.vera.springbootmall.dto.ProductRequest;
import com.vera.springbootmall.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
