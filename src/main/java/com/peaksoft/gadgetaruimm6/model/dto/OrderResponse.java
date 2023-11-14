package com.peaksoft.gadgetaruimm6.model.dto;

import com.peaksoft.gadgetaruimm6.model.enums.PaymentType;
import com.peaksoft.gadgetaruimm6.model.enums.Shipping;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data

@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {
     Long id;
     Double endSum;
     String address;
     PaymentType paymentType;
     Shipping shipping;

}
