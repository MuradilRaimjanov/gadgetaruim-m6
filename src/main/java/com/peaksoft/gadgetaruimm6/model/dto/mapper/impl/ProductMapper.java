package com.peaksoft.gadgetaruimm6.model.dto.mapper.impl;

import com.peaksoft.gadgetaruimm6.model.dto.ProductRequest;
import com.peaksoft.gadgetaruimm6.model.dto.ProductResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.Mapper;
import com.peaksoft.gadgetaruimm6.model.entity.Product;
import com.peaksoft.gadgetaruimm6.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductMapper implements Mapper<ProductRequest, Product, ProductResponse> {

    BrandMapper brandMapper;
    @Override
    public Product mapToEntity(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .weight(productRequest.getWeight())
                .image(productRequest.getImage())
                .screen(productRequest.getScreen())
                .guarantee(productRequest.getGuarantee())
                .description(productRequest.getDescription())
                .processor(productRequest.getProcessor())
                .memory(productRequest.getMemory())
                .memoryRam(productRequest.getMemoryRam())
                .form(productRequest.getForm())
                .categoryType(productRequest.getCategoryType())
                .color(productRequest.getColor())
                .os(productRequest.getOs())
                .releaseDate(LocalDate.from(LocalDate.now()))
                .quantitySimCards(productRequest.getQuantitySimCards())
                .enginePower(productRequest.getEnginePower())
                .diameterOfTheRear(productRequest.getDiameterOfTheRear())
                .build();
    }

    @Override
    public ProductResponse mapToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .brandName(product.getName())
                .color(product.getColor())
                .releaseDate(LocalDate.now())
                .os(product.getOs())
                .memory(product.getMemory())
                .memoryRam(product.getMemoryRam())
                .quantitySimCards(product.getQuantitySimCards())
                .weight(product.getWeight())
                .guarantee(product.getGuarantee())
                .image(product.getImage())
                .screen(product.getScreen())
                .description(product.getDescription())
                .filePDF(product.getFilePDF())
                .fileVideo(product.getFileVideo())
                .quantityOfProduct(product.getQuantityOfProducts())
                .discount(product.getDiscount())
                .enginePower(product.getEnginePower())
                .categoryType(product.getCategoryType())
                .processor(product.getProcessor())
                .feedbacks(product.getFeedbacks())
                .build();
    }
}
