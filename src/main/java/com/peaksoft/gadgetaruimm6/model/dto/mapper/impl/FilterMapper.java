package com.peaksoft.gadgetaruimm6.model.dto.mapper.impl;

import com.peaksoft.gadgetaruimm6.model.dto.FilterRequest;
import com.peaksoft.gadgetaruimm6.model.dto.FilterResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.Mapper;

import com.peaksoft.gadgetaruimm6.model.entity.Product;
import com.peaksoft.gadgetaruimm6.repository.ProductFilterRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PACKAGE, makeFinal = true)
public class FilterMapper implements Mapper<FilterRequest, List<Product>, List<FilterResponse>> {
    ProductFilterRepository productRepository;

    @Override
    public List<Product> mapToEntity(FilterRequest filterRequest) {
        return productRepository.filter(
                filterRequest.getBrands(),
                filterRequest.getColors(),
                filterRequest.getRams(),
                filterRequest.getRoms(),
                filterRequest.getPriceFrom(),
                filterRequest.getPriceTo()
                );
    }

    @Override
    public List<FilterResponse> mapToResponse(List<Product> products) {
        List<FilterResponse> responses = new ArrayList<>();
        products.stream().map(product -> responses.add(new FilterResponse(
            product.getId(),
                product.getWeight(),
                product.getName(),
                product.getImage(),
                product.getPrice(),
                product.getScreen(),
                product.getGuarantee(),
                product.getProcessor(),
                product.getDescription(),
                product.getFilePDF(),
                product.getFileVideo(),
                product.getCategoryType(),
                product.getColor(),
                product.getOs(),
                product.getMemoryRom(),
                product.getMemoryRam(),
                product.getReleaseDate(),
                product.getDateIssue(),
                product.getQuantitySimCards(),
                product.getArticleNumber(),
                product.getTrackType(),
                product.getEnginePower(),
                product.getEngineType(),
                product.getSpeedAdjustment(),
                product.getPunningTrack(),
                product.getSlopeOfTheTreadmill(),
                product.getDiameterOfTheRear(),
                product.getProgramTraining(),
                product.getDisplayInch(),
                product.getCapacityBattery(),
                product.getQuantityOfProducts()
        ))).collect(Collectors.toList());
        return responses;
    }
}
