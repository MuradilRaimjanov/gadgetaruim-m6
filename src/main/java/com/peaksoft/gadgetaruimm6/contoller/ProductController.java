package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.ProductRequest;
import com.peaksoft.gadgetaruimm6.model.dto.ProductResponse;
import com.peaksoft.gadgetaruimm6.model.enums.SortBy;
import com.peaksoft.gadgetaruimm6.service.impl.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

    ProductService productService;

    @PostMapping("/save/{brandId}")
    public ProductResponse saveProduct(@PathVariable Long brandId, @RequestBody ProductRequest productRequest) {
        return productService.saveProduct(brandId, productRequest);
    }

    @PostMapping("/{id}")
    public ProductResponse savePrice(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return productService.setPricesAndQuantities(id, productRequest);
    }
    @PostMapping("/description/{id}")
    public ProductResponse saveDescription(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return productService.setDescription(id, productRequest);
    }

    @GetMapping("{id}")
    public ProductResponse findProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/all")
    public List<ProductResponse> findAllProduct(@RequestParam(value = "sort") SortBy sortBy) {
        return productService.findAllProducts(sortBy);
    }

    @PutMapping("{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return productService.update(id, productRequest);
    }

    @DeleteMapping("{id}")
    public ProductResponse deleteProductById(@PathVariable Long id) {
        return productService.delete(id);
    }

}
