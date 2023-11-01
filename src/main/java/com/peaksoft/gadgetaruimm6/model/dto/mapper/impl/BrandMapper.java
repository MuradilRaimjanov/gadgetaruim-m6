package com.peaksoft.gadgetaruimm6.model.dto.mapper.impl;

import com.peaksoft.gadgetaruimm6.model.dto.BrandRequest;
import com.peaksoft.gadgetaruimm6.model.dto.BrandResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.Mapper;
import com.peaksoft.gadgetaruimm6.model.entity.Brand;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BrandMapper implements Mapper<BrandRequest, Brand, BrandResponse> {
    @Override
    public Brand mapToEntity(BrandRequest brandRequest) {
        return Brand.builder()
                .brandName(brandRequest.getBrandName())
                .image(brandRequest.getImage())
                .build();
    }

    @Override
    public BrandResponse mapToResponse(Brand brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .brandName(brand.getBrandName())
                .image(brand.getImage())
                .brandName(brand.getBrandName())
                .localDate(LocalDate.from(LocalDate.now().atStartOfDay()))
                .build();
    }
}

