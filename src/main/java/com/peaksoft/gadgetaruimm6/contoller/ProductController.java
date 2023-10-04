package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.mapper.ProductRequest;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.ProductResponse;
import com.peaksoft.gadgetaruimm6.service.impl.ProductService;
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
public class ProductController {

    ProductService productService;

    @GetMapping("/filter")
    public List<ProductResponse> filterCatalog(@RequestBody ProductRequest productRequest) {
        return productService.filterCatalog(productRequest);
    }

}
