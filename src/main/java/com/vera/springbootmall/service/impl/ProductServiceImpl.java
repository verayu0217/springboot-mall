package com.vera.springbootmall.service.impl;

import com.vera.springbootmall.dao.ProductDao;
import com.vera.springbootmall.model.Product;
import com.vera.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
