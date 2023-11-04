package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.ProductDescriptionRequest;
import com.peaksoft.gadgetaruimm6.model.dto.ProductPriceRequest;
import com.peaksoft.gadgetaruimm6.model.dto.ProductRequest;
import com.peaksoft.gadgetaruimm6.model.dto.ProductResponse;
import com.peaksoft.gadgetaruimm6.model.enums.SortBy;
import com.peaksoft.gadgetaruimm6.service.impl.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Tag(name = "Product controller")
public class ProductController {

    ProductService productService;

    @PostMapping("/save/{brandId}")
    @Operation(description = "This method is to save product by brandId")
    public ProductResponse saveProduct(@PathVariable Long brandId, @RequestBody ProductRequest productRequest) {
        return productService.saveProduct(brandId, productRequest);
    }

    @PostMapping("/{id}")
    @Operation(description = "Using this method, we substitute the price for the product by id ")
    public ProductResponse savePrice(@PathVariable Long id, @RequestBody ProductPriceRequest productPriceRequest) {
        return productService.setPricesAndQuantities(id,productPriceRequest);
    }
    @PostMapping("/description/{id}")
    @Operation(description = "Using this method we describe the product by id")
    public ProductResponse saveDescription(@PathVariable Long id, @RequestBody ProductDescriptionRequest descriptionRequest) {
        return productService.setDescription(id,descriptionRequest );
    }

    @GetMapping("{id}")
    @Operation(description = "This method find product by id")
    public ProductResponse findProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/all")
    @Operation(description = "With this method we get all products")
    public List<ProductResponse> findAllProduct(@RequestParam(value = "sort") SortBy sortBy) {
        return productService.findAllProducts(sortBy);
    }

    @PutMapping("{id}")
    @Operation(description = "This method updates the product by id")
    public ProductResponse updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return productService.update(id, productRequest);
    }

    @DeleteMapping("{id}")
    @Operation(description = "This method removes product by id")
    public ProductResponse deleteProductById(@PathVariable Long id) {
        return productService.delete(id);
    }

}
