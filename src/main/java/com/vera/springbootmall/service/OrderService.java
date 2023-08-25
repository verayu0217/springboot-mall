package com.vera.springbootmall.service;

import com.vera.springbootmall.dto.CreateOrderRequest;
import com.vera.springbootmall.model.Order;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);

}
