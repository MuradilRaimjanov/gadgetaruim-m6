package com.peaksoft.gadgetaruimm6.service.impl;

import com.peaksoft.gadgetaruimm6.model.dto.OrderRequest;
import com.peaksoft.gadgetaruimm6.model.dto.OrderResponse;
import com.peaksoft.gadgetaruimm6.model.dto.ResponseToTheOrderForDelivery;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.OrderForDeliveryMapper;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.OrderMapper;
import com.peaksoft.gadgetaruimm6.model.entity.*;
import com.peaksoft.gadgetaruimm6.model.enums.Shipping;
import com.peaksoft.gadgetaruimm6.repository.BasketRepository;
import com.peaksoft.gadgetaruimm6.repository.OrderRepository;
import com.peaksoft.gadgetaruimm6.repository.OrderReviewRepository;
import com.peaksoft.gadgetaruimm6.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)

public class OrderServiceImpl implements OrderService {

     BasketRepository basketRepository;
      OrderReviewRepository orderReviewRepository;
     OrderRepository orderRepository;
     OrderMapper orderMapper;
     OrderForDeliveryMapper orderForDeliveryMapper;





    @Override
    public ResponseToTheOrderForDelivery saveMain(String orderReview, Long basketId, OrderRequest orderRequest) {
        Basket basket = basketRepository.findById(basketId).get();
        OrderReview orderReview1 = orderReviewRepository.findByOrderReview(orderReview).get();
        Order order = orderMapper.mapToEntity(orderRequest);
        basket.setOrder(order);
        order.setBasket(basket);
        order.setOrderReview(orderReview1);
        User user = basket.getUser();
        if (order.getShipping() == Shipping.PICK_UP_FROM_THE_STORE) {
            order.setUser(user);
        }else  if (order.getShipping() == Shipping.DELIVERY_BY_COURIER) {
            Address address = new Address();
            address.setCountryName(orderRequest.getCountryName());
            address.setCityName(orderRequest.getCityName());
            address.setStreetName(orderRequest.getStreetName());
            address.setPostalCode(orderRequest.getPostalCode());
            user.setAddress(address);
            order.setUser(user);
        }
        order.setCountOfProducts((short) basket.getQuantityOfProducts());
        orderRepository.save(order);
        basketRepository.save(basket);
        return orderForDeliveryMapper.mapToResponse(order);
    }

    @Override
    public OrderResponse savePayment(Long id, String orderReview, OrderRequest orderRequest) {
        Order order = orderRepository.findById(id).get();
        OrderReview orderReviewEntity = orderReviewRepository.findByOrderReview(orderReview).get();
        order.setOrderReview(orderReviewEntity);
        order.setPaymentType(null);
        orderRepository.save(order);
        return orderMapper.mapToResponse(order);
    }

    @Override
    public OrderResponse saveOrderReview(Long id, String orderReview) {
        Order order = orderRepository.findById(id).get();
        OrderReview orderReviewEntity = orderReviewRepository.findByOrderReview(orderReview).get();
        order.setOrderReview(orderReviewEntity);
        order.setTotalSum(order.getBasket().getEndSum());
        orderRepository.save(order);
        return orderMapper.mapToResponse(order);

    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }


}
