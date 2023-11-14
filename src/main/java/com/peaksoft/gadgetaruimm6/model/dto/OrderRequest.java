package com.peaksoft.gadgetaruimm6.model.dto;

import com.peaksoft.gadgetaruimm6.model.enums.OrderStatus;
import com.peaksoft.gadgetaruimm6.model.enums.PaymentType;
import com.peaksoft.gadgetaruimm6.model.enums.Shipping;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    Shipping shipping;
    PaymentType typePayment;
    OrderStatus orderStatus;
    Long userId;
    String countryName;
    String cityName;
    String streetName;
    String stateName;
    String postalCode;
}

