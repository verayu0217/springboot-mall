package com.vera.springbootmall.service.impl;

import com.vera.springbootmall.dao.OrderDao;
import com.vera.springbootmall.dao.ProductDao;
import com.vera.springbootmall.dto.BuyItem;
import com.vera.springbootmall.dto.CreateOrderRequest;
import com.vera.springbootmall.model.Order;
import com.vera.springbootmall.model.OrderItem;
import com.vera.springbootmall.model.Product;
import com.vera.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for(BuyItem buyItem : createOrderRequest.getBuyItemList()){//for loop使用者購買的每個商品
            Product product = productDao.getProductById(buyItem.getProductId());//根據前端傳過來productId的值先去資料庫查詢product數據

            //計算總價錢
            int amount = buyItem.getQuantity() *  product.getPrice();
            totalAmount = totalAmount + amount;

            //轉換BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        //創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }

}
