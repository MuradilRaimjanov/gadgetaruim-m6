package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.BrandResponse;
import com.peaksoft.gadgetaruimm6.model.dto.ProductRequest;
import com.peaksoft.gadgetaruimm6.model.dto.ProductResponse;
import com.peaksoft.gadgetaruimm6.service.impl.BrandService;
import com.peaksoft.gadgetaruimm6.service.impl.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

    ProductService productService;
    BrandService brandService;

    @PostMapping("/{brand_id}")
    public ProductResponse saveProduct(@PathVariable("brand_id") Long brandId, @RequestBody ProductRequest productRequest) {
        BrandResponse brand = brandService.findById(brandId);
        brand.setBrandName(brand.getBrandName());
        brand.setImage(brand.getImage());
        return productService.save(productRequest);
    }

    @PostMapping("/{id}")
    public ProductResponse savePrice(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return productService.setPricesAndQuantities(id, productRequest);
    }

    @GetMapping("{id}")
    public ProductResponse findProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping
    public List<ProductResponse> findAllProduct() {
        return productService.findAll();
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
