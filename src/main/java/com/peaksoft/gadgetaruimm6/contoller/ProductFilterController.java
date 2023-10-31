package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.FilterRequest;
import com.peaksoft.gadgetaruimm6.model.dto.FilterResponse;
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
@RequestMapping("/api/filter")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductFilterController {

    ProductFilterService productService;

    @GetMapping("/filter-by")
    public List<FilterResponse> filterCatalog(@RequestBody FilterRequest productRequest) {
        return productService.filterCatalog(productRequest);
    }

}
