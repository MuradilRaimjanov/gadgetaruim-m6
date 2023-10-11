package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.BrandRequest;
import com.peaksoft.gadgetaruimm6.model.dto.BrandResponse;
import com.peaksoft.gadgetaruimm6.service.impl.BrandService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brands")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BrandController {

    BrandService brandService;

    @PostMapping()
    public BrandResponse save(@RequestBody BrandRequest brandRequest) {
        return brandService.save(brandRequest);
    }

    @GetMapping("{id}")
    public BrandResponse findBrandById(@PathVariable Long id) {
        return brandService.findById(id);
    }

    @GetMapping
    public List<BrandResponse> findAllBrand() {
        return brandService.findAll();
    }

    @PutMapping("{id}")
    public BrandResponse updateBrand(@PathVariable Long id, @RequestBody BrandRequest brandRequest) {
        return brandService.update(id, brandRequest);
    }

    @DeleteMapping("{id}")
    public BrandResponse deleteBrandById(@PathVariable Long id) {
        return brandService.delete(id);
    }
}
