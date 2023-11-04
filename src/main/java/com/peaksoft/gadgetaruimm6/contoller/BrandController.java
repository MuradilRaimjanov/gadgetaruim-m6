package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.BrandRequest;
import com.peaksoft.gadgetaruimm6.model.dto.BrandResponse;
import com.peaksoft.gadgetaruimm6.service.impl.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brands")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Tag(name = "Brand controller ")
public class BrandController {

    BrandService brandService;

    @PostMapping("/save")
    @Operation(description = "This method is to save the brand")
    public BrandResponse save(@RequestBody BrandRequest brandRequest) {
        return brandService.save(brandRequest);
    }

    @GetMapping("{id}")
    @Operation(description = "This method find brand by id")
    public BrandResponse findBrandById(@PathVariable Long id) {
        return brandService.findById(id);
    }

    @GetMapping
    @Operation(description = "With this method we get all brands")
    public List<BrandResponse> findAllBrand() {
        return brandService.findAll();
    }

    @PutMapping("{id}")
    @Operation(description = "This method updates the brand by id")
    public BrandResponse updateBrand(@PathVariable Long id, @RequestBody BrandRequest brandRequest) {
        return brandService.update(id, brandRequest);
    }

    @DeleteMapping("{id}")
    @Operation(description = "This method removes brand by id")
    public BrandResponse deleteBrandById(@PathVariable Long id) {
        return brandService.delete(id);
    }
}
