package com.peaksoft.gadgetaruimm6.service;

import com.peaksoft.gadgetaruimm6.model.dto.DiscountRequest;
import com.peaksoft.gadgetaruimm6.model.dto.DiscountResponse;

public interface DiscountService {

    DiscountResponse save(DiscountRequest discountRequest);

    DiscountResponse update(Long id, DiscountRequest discountRequest);

    String delete(Long id);
}
