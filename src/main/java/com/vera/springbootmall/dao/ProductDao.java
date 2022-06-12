package com.vera.springbootmall.dao;

import com.vera.springbootmall.dto.ProductRequest;
import com.vera.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
