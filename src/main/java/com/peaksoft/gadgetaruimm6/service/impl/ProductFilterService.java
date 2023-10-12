package com.peaksoft.gadgetaruimm6.service.impl;

import com.peaksoft.gadgetaruimm6.exception.ProductNotFoundException;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.FilterRequest;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.FilterResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.FilterMapper;
import com.peaksoft.gadgetaruimm6.model.entity.Product;
import com.peaksoft.gadgetaruimm6.repository.ProductFilterRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductFilterService {

    ProductFilterRepository productRepository;
    FilterMapper productFilterMapper;

    public List<FilterResponse> filterCatalog(FilterRequest productRequest) {
        List<Product> products;

        switch (productRequest.getSortBy()) {
            case BY_NEW -> {
                products = productRepository.filterNew(
                        productRequest.getBrands(),
                        productRequest.getColors(),
                        productRequest.getRams(),
                        productRequest.getRoms(),
                        productRequest.getPriceFrom(),
                        productRequest.getPriceTo()
                );
            }
            case BY_ASC -> {
                products = productRepository.filterAsc(
                        productRequest.getBrands(),
                        productRequest.getColors(),
                        productRequest.getRams(),
                        productRequest.getRoms(),
                        productRequest.getPriceFrom(),
                        productRequest.getPriceTo()
                );
            }
            case BY_DESC -> {
                products = productRepository.filterDesc(
                        productRequest.getBrands(),
                        productRequest.getColors(),
                        productRequest.getRams(),
                        productRequest.getRoms(),
                        productRequest.getPriceFrom(),
                        productRequest.getPriceTo()
                );
            }
            case BY_SALE -> {
                products = productRepository.filterSale(
                        productRequest.getBrands(),
                        productRequest.getColors(),
                        productRequest.getRams(),
                        productRequest.getRoms(),
                        productRequest.getPriceFrom(),
                        productRequest.getPriceTo()
                );
            }
            case BY_SALE_UP -> {
                products = productRepository.filterSaleUp(
                        productRequest.getBrands(),
                        productRequest.getColors(),
                        productRequest.getRams(),
                        productRequest.getRoms(),
                        productRequest.getPriceFrom(),
                        productRequest.getPriceTo()
                );
            }
            case BY_REC -> {
                products = productRepository.filterRec(
                        productRequest.getBrands(),
                        productRequest.getColors(),
                        productRequest.getRams(),
                        productRequest.getRoms(),
                        productRequest.getPriceFrom(),
                        productRequest.getPriceTo()
                );
            }
            default -> {
                products = productRepository.filter(
                        productRequest.getBrands(),
                        productRequest.getColors(),
                        productRequest.getRams(),
                        productRequest.getRoms(),
                        productRequest.getPriceFrom(),
                        productRequest.getPriceTo()
                );
            }
        }
        if (products.isEmpty()) {
            throw new ProductNotFoundException("ProductList is empty!!!");
        } else {
            return productFilterMapper.mapToResponse(products);
        }

    }

}
