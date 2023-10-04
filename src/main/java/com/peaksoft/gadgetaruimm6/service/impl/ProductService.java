package com.peaksoft.gadgetaruimm6.service.impl;

import com.peaksoft.gadgetaruimm6.exception.ProductNotFoundException;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.ProductRequest;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.ProductResponse;
import com.peaksoft.gadgetaruimm6.model.entity.Product;
import com.peaksoft.gadgetaruimm6.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {

    ProductRepository productRepository;

    public List<ProductResponse> filterCatalog(ProductRequest productRequest) {
        List<Product> list = productRepository.filterCatalog(
                productRequest.getBrands(),
                productRequest.getColors(),
                productRequest.getRams(),
                productRequest.getRoms(),
                productRequest.getPriceFrom(),
                productRequest.getPriceTo());

        List<ProductResponse> responses = new ArrayList<>();
        list.stream().map(product -> responses.add(new ProductResponse(
                product.getId(),
                product.getWeight(),
                product.getName(),
                product.getImage(),
                product.getPrice(),
                product.getScreen(),
                product.getGuarantee(),
                product.getProcessor(),
                product.getDescription(),
                product.getRom(),
                product.getRam(),
                product.getCategoryType(),
                product.getBrand(),
                product.getColor(),
                product.getOs(),
                product.getMemory(),
                product.getReleaseDate(),
                product.getQuantitySimCards(),
                product.getArticleNumber(),
                product.getTrackType(),
                product.getEnginePower(),
                product.getEngineType(),
                product.getSpeedAdjustment(),
                product.getPunningTrack(),
                product.getSlopeOfTheTreadmill(),
                product.getDiameterOfTheRear(),
                product.getProgramTraining()
        ))).collect(Collectors.toList());
        if (responses.isEmpty()){
            throw new ProductNotFoundException();
        }
        return responses;
    }

}
