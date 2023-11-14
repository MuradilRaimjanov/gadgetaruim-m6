package com.peaksoft.gadgetaruimm6.model.dto.mapper.impl;

import com.peaksoft.gadgetaruimm6.model.dto.ResponseToTheOrderForDelivery;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.Mapper;
import com.peaksoft.gadgetaruimm6.model.entity.Order;
import com.peaksoft.gadgetaruimm6.model.enums.Shipping;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
public class OrderForDeliveryMapper  {

    public ResponseToTheOrderForDelivery mapToResponse(Order order) {
        ResponseToTheOrderForDelivery orderResponseForVarietyOfDelivery = new ResponseToTheOrderForDelivery();
        orderResponseForVarietyOfDelivery.setId(order.getId());
        orderResponseForVarietyOfDelivery.setName(order.getUser().getFirstName());
        orderResponseForVarietyOfDelivery.setLastName(order.getUser().getLastName());
        orderResponseForVarietyOfDelivery.setEmail(order.getUser().getEmail());
        orderResponseForVarietyOfDelivery.setPhoneNumber(order.getUser().getPhoneNumber());
        if (order.getShipping() == Shipping.DELIVERY_BY_COURIER) {
            orderResponseForVarietyOfDelivery.setAddress(order.getUser().getAddress().getCountryName() + ", "
                    + order.getUser().getAddress().getCityName() + ", " + order.getUser().getAddress().getStreetName() + ", "
                    + order.getUser().getAddress().getPostalCode());
            orderResponseForVarietyOfDelivery.setShipping(order.getShipping().getName());
        } else if (order.getShipping() == Shipping.PICK_UP_FROM_THE_STORE) {
            orderResponseForVarietyOfDelivery.setShipping(order.getShipping().getName());
        }
        return orderResponseForVarietyOfDelivery;
    }
}
