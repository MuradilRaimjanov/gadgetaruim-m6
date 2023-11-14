package com.peaksoft.gadgetaruimm6.service;

import com.peaksoft.gadgetaruimm6.model.dto.OrderRequest;
import com.peaksoft.gadgetaruimm6.model.dto.OrderResponse;
import com.peaksoft.gadgetaruimm6.model.dto.ResponseToTheOrderForDelivery;
import com.peaksoft.gadgetaruimm6.model.entity.Order;

import java.util.Optional;

public interface OrderService {

    ResponseToTheOrderForDelivery saveMain(String orderReview, Long basketId, OrderRequest orderRequest);

    OrderResponse savePayment(Long id, String orderReview, OrderRequest orderRequest);

    OrderResponse saveOrderReview(Long id, String orderReview);
    Optional<Order> getOrderById(Long orderId);
//    Long postOrder(User user, OrderRequest orderRequest);
}
