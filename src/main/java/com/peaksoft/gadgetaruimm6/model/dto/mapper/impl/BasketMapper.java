package com.peaksoft.gadgetaruimm6.model.dto.mapper.impl;

import com.peaksoft.gadgetaruimm6.model.dto.mapper.BasketResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.ProductFilterResponse;
import com.peaksoft.gadgetaruimm6.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BasketMapper {


    public List<ProductFilterResponse> mapToResponse(List<Product> products) {
        List<ProductFilterResponse> responses = new ArrayList<>();
        products.stream().map(product -> responses.add(new ProductFilterResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImage(),
                product.getDescription(),
                product.getDateIssue(),
                product.getScreen(),
                product.getGuarantee(),
                product.getProcessor(),
                product.getWeight(),
                product.getBrand(),
                product.getColor(),
                product.getOs(),
                product.getPdf(),
                product.getMemory(),
                product.getMemoryRam(),
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
                product.getInBasket()
        ))).collect(Collectors.toList());
        return responses;
    }
}
