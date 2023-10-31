package com.peaksoft.gadgetaruimm6.model.dto.mapper.impl;

import com.peaksoft.gadgetaruimm6.model.dto.ProductRequest;
import com.peaksoft.gadgetaruimm6.model.dto.ProductResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.Mapper;
import com.peaksoft.gadgetaruimm6.model.entity.Product;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductMapper implements Mapper<ProductRequest, Product, ProductResponse> {
    @Override
    public Product mapToEntity(ProductRequest productRequest) {
        return Product.builder()
                .weight(productRequest.getWeight())
                .name(productRequest.getName())
                .image(productRequest.getImage())
                .screen(productRequest.getScreen())
                .guarantee(productRequest.getGuarantee())
                .processor(productRequest.getProcessor())
                .description(productRequest.getDescription())
                .categoryType(productRequest.getCategoryType())
                .form(productRequest.getForm())
                .color(productRequest.getColor())
                .os(productRequest.getOs())
                .memoryRam(productRequest.getMemoryRam())
                .memoryRom(productRequest.getMemoryRom())
                .releaseDate(LocalDate.now())
                .enginePower(productRequest.getEnginePower())
                .diameterOfTheRear(productRequest.getDiameterOfTheRear())
                .filePDF(productRequest.getFilePDF())
                .fileVideo(productRequest.getFileVideo())
                .price(productRequest.getPrice())
                .quantityOfProducts(productRequest.getQuantityOfProducts())
                .build();
    }

    @Override
    public ProductResponse mapToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .color(product.getColor())
                .releaseDate(LocalDate.now())
                .os(product.getOs())
                .memoryRom(product.getMemoryRom())
                .memoryRam(product.getMemoryRam())
                .quantitySimCards(product.getQuantitySimCards())
                .weight(product.getWeight())
                .guarantee(product.getGuarantee())
                .image(product.getImage())
                .screen(product.getScreen())
                .description(product.getDescription())
                .filePDF(product.getFilePDF())
                .fileVideo(product.getFileVideo())
                .quantityOfProducts(product.getQuantityOfProducts())
                .enginePower(product.getEnginePower())
                .categoryType(product.getCategoryType())
                .processor(product.getProcessor())
                .build();
    }
}
