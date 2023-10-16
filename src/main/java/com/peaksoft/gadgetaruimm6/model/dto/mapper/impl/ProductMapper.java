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
    ProductRepository productRepository;

    @Override
    public Product mapToEntity(ProductRequest productRequest) {
        return Product.builder()
                .weight(productRequest.getWeight())
                .name(productRequest.getName())
                .image(productRequest.getImage())
                .price(Integer.parseInt(productRequest.getPrice()))
                .screen(productRequest.getScreen())
                .guarantee(productRequest.getGuarantee())
                .processor(productRequest.getProcessor())
                .description(productRequest.getDescription())
                .fileVideo(productRequest.getFileVideo())
                .filePDF(productRequest.getFilePDF())
                .gender(productRequest.getGender())
                .form(productRequest.getForm())
                .waterproof(productRequest.getWaterproof())
                .wireless(productRequest.getWireless())
                .categoryType(productRequest.getCategoryType())
                .color(productRequest.getColor())
                .os(productRequest.getOs())
                .releaseDate(LocalDate.from(LocalDate.now()))
                .quantitySimCards(productRequest.getQuantitySimCards())
                .quantityOfProducts(productRequest.getQuantityOfProduct())
                .articleNumber(productRequest.getArticleNumber())
                .trackType(productRequest.getTrackType())
                .enginePower(productRequest.getEnginePower())
                .engineType(productRequest.getEngineType())
                .speedAdjustment(productRequest.getSpeedAdjustment())
                .punningTrack(productRequest.getPunningTrack())
                .slopeOfTheTreadmill(productRequest.getSlopeOfTheTreadmill())
                .diameterOfTheRear(productRequest.getDiameterOfTheRear())
                .programTraining(productRequest.getProgramTraining())
                .build();
    }

    @Override
    public ProductResponse mapToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .weight(product.getWeight())
                .name(product.getName())
                .image(product.getImage())
                .price(String.valueOf(product.getPrice()))
                .brands(product.getBrands().stream().map(brandMapper::mapToResponse).collect(Collectors.toList()))
                .screen(product.getScreen())
                .guarantee(product.getGuarantee())
                .processor(product.getProcessor())
                .description(product.getDescription())
                .filePDF(product.getFilePDF())
                .fileVideo(product.getFileVideo())
                .form(product.getForm())
                .waterproof(product.getWaterproof())
                .wireless(product.getWireless())
                .gender(product.getGender())
                .categoryType(product.getCategoryType())
                .color(product.getColor())
                .os(product.getOs())
                .memory(product.getMemory())
                .releaseDate(LocalDate.now())
                .quantitySimCards(product.getQuantitySimCards())
                .articleNumber(product.getArticleNumber())
                .trackType(product.getTrackType())
                .enginePower(product.getEnginePower())
                .speedAdjustment(product.getSpeedAdjustment())
                .punningTrack(product.getPunningTrack())
                .slopeOfTheTreadmill(product.getSlopeOfTheTreadmill())
                .diameterOfTheRear(product.getDiameterOfTheRear())
                .programTraining(product.getProgramTraining())
                .discount(product.getDiscount())
                .feedbacks(product.getFeedbacks())
                .build();
    }
}
