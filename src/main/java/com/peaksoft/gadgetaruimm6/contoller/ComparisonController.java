package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.ComparisonResponse;
import com.peaksoft.gadgetaruimm6.model.enums.CategoryType;
import com.peaksoft.gadgetaruimm6.service.impl.ComparisonServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/compare")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ComparisonController {

    ComparisonServiceImpl comparisonService;

    @PostMapping
    public ResponseEntity<?> addToComparison(@RequestParam Long id, Principal principal) {
        return comparisonService.addToComparison(id, principal);
    }

    @GetMapping
    public List<ComparisonResponse> getComparisonListBySubCategory(@RequestParam CategoryType categoryType, Principal principal) {
        return comparisonService.getComparisonListBySubCategory(categoryType, principal);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(Principal principal){
        comparisonService.getClear(principal);
        return ResponseEntity.ok().body("Successfully");
    }

    @GetMapping("/unique")
    public List<ComparisonResponse> uniqueProducts(@RequestParam CategoryType categoryType, Principal principal){
        return comparisonService.getComparisonListBySubCategory(categoryType, principal);
    }

}
