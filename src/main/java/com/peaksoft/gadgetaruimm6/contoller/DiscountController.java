package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.DiscountRequest;
import com.peaksoft.gadgetaruimm6.model.dto.DiscountResponse;
import com.peaksoft.gadgetaruimm6.service.DiscountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/discount/")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DiscountController {

    DiscountService discountService;

    @PostMapping("/save")
    public DiscountResponse save(@RequestBody DiscountRequest discountRequest) {
        return discountService.save(discountRequest);
    }
    @PutMapping("/update/{id}")
    public DiscountResponse update(@PathVariable("id") Long id,  @RequestBody DiscountRequest discountRequest) {
        return discountService.update(id, discountRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return discountService.delete(id);
    }
}
