package com.vera.springbootmall.service;

import com.vera.springbootmall.dto.CreateOrderRequest;
import com.vera.springbootmall.dto.OrderQueryParams;
import com.vera.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);
    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
    Order getOrderById(Integer orderId);

}
