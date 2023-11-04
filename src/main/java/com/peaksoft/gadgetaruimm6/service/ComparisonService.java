package com.peaksoft.gadgetaruimm6.service;

import com.peaksoft.gadgetaruimm6.model.dto.ComparisonResponse;
import com.peaksoft.gadgetaruimm6.model.enums.CategoryType;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.List;

public interface ComparisonService {

    ResponseEntity<String> addToComparison(Long id, Principal principal);

    List<ComparisonResponse> getComparisonListBySubCategory(CategoryType categoryType, Principal principal);

    void getClear(Principal principal);

}
