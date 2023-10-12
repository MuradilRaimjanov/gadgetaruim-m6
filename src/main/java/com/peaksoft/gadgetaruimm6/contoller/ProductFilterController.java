package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.mapper.FilterRequest;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.FilterResponse;
import com.peaksoft.gadgetaruimm6.service.impl.ProductFilterService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductFilterController {

    ProductFilterService productService;

    @GetMapping("/filter")
    public List<FilterResponse> filterCatalog(@RequestBody FilterRequest productRequest) {
        return productService.filterCatalog(productRequest);
    }

}