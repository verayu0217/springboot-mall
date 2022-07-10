package com.vera.springbootmall.dao;

import com.vera.springbootmall.constant.ProductCategory;
import com.vera.springbootmall.dto.ProductRequest;
import com.vera.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts(ProductCategory category,String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
