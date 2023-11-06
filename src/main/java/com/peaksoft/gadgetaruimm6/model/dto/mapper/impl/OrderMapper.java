package com.peaksoft.gadgetaruimm6.model.dto.mapper.impl;

import com.peaksoft.gadgetaruimm6.model.dto.OrderRequest;
import com.peaksoft.gadgetaruimm6.model.dto.OrderResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.Mapper;
import com.peaksoft.gadgetaruimm6.model.entity.Order;
import com.peaksoft.gadgetaruimm6.model.enums.OrderStatus;
import com.peaksoft.gadgetaruimm6.model.enums.Shipping;
import com.peaksoft.gadgetaruimm6.repository.OrderRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Component
public class OrderMapper implements Mapper<OrderRequest, Order, OrderResponse> {

    @Override
    public Order mapToEntity(OrderRequest orderRequest) {
        return Order.builder()
                .shipping(orderRequest.getShipping())
                .paymentType(orderRequest.getTypePayment())
                .orderStatus(orderRequest.getOrderStatus())
                .build();
    }

    @Override
    public OrderResponse mapToResponse(Order order) {
        OrderResponse orderResponse=new OrderResponse();
        orderResponse.setId(order.getId());
        if (order.getShipping() == Shipping.DELIVERY_BY_COURIER) {
            orderResponse.setAddress(order.getUser().getAddress().getCountryName() + ", " + order.getUser().getAddress().getCityName() + ", " + order.getUser().getAddress().getStreetName() + ", " + order.getUser().getAddress().getPostalCode());
            orderResponse.setShipping(Shipping.valueOf(order.getShipping().getName()));
        } else if (order.getShipping() == Shipping.PICK_UP_FROM_THE_STORE) {
            orderResponse.setShipping(Shipping.valueOf(order.getShipping().getName()));
        }
        orderResponse.setEndSum(order.getTotalSum());
        return orderResponse;


    }
}
