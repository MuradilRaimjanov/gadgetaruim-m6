package com.peaksoft.gadgetaruimm6.model.dto.mapper.impl;

import com.peaksoft.gadgetaruimm6.model.dto.ComparisonResponse;
import com.peaksoft.gadgetaruimm6.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ComparisonMapper {

    public List<ComparisonResponse> mapToResponse(List<Product> productList) {
        List<ComparisonResponse> responses = new ArrayList<>();
        productList.stream().map(product -> responses.add(new ComparisonResponse(
                product.getId(),
                product.getImage(),
                product.getBrand().getBrandName(),
                product.getColor(),
                product.getOs(),
                product.getMemoryRam(),
                product.getWeight(),
                product.getQuantitySimCards()
        ))).collect(Collectors.toList());

        return responses;
    }
}
