package com.Crypto.service;

import com.Crypto.domain.OrderType;
import com.Crypto.model.Coin;
import com.Crypto.model.Order;
import com.Crypto.model.OrderItem;
import com.Crypto.model.User;

import java.util.List;

public interface OrderService {
    Order createOrder(User user, OrderItem orderItem, OrderType orderType);

    Order getOrderById(Long orderId) throws Exception;

    List<Order> getAllOrdersOfUser(Long userId, OrderType orderType, String assetSymbol);

    Order processOrder(Coin coin, double quantity, OrderType orderType, User user) throws Exception;

}
