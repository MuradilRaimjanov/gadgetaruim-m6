package com.peaksoft.gadgetaruimm6.model.dto.mapper.impl;

import com.peaksoft.gadgetaruimm6.model.dto.DiscountRequest;
import com.peaksoft.gadgetaruimm6.model.dto.DiscountResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.Mapper;
import com.peaksoft.gadgetaruimm6.model.entity.Discount;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DiscountMapper implements Mapper<DiscountRequest, Discount, DiscountResponse> {

    @Override
    public Discount mapToEntity(DiscountRequest discountRequest) {
         return Discount.builder()
                .percent(discountRequest.getPercent())
                .start(discountRequest.getDateOfStart())
                .finish(discountRequest.getDateOfEnd())
                .build();
    }

    @Override
    public DiscountResponse mapToResponse(Discount discount) {
        return DiscountResponse.builder()
                .id(discount.getId())
                .percent(discount.getPercent())
                .dateOfStart(discount.getStart())
                .dateOfEnd(discount.getFinish())
                .build();
    }
}
