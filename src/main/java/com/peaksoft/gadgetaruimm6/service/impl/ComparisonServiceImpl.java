package com.peaksoft.gadgetaruimm6.service.impl;

import com.peaksoft.gadgetaruimm6.model.dto.ComparisonResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.ComparisonMapper;
import com.peaksoft.gadgetaruimm6.model.entity.Product;
import com.peaksoft.gadgetaruimm6.model.entity.User;
import com.peaksoft.gadgetaruimm6.model.enums.CategoryType;
import com.peaksoft.gadgetaruimm6.repository.ComparisonRepository;
import com.peaksoft.gadgetaruimm6.repository.ProductRepository;
import com.peaksoft.gadgetaruimm6.repository.UserRepository;
import com.peaksoft.gadgetaruimm6.service.ComparisonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ComparisonServiceImpl implements ComparisonService {

    ProductRepository productRepository;
    UserRepository userRepository;
    ComparisonMapper mapper;
    ComparisonRepository comparisonRepository;


    @Override
    public ResponseEntity<String> addToComparison(Long id, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        Product product = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Product with id" + id + " not found!!!"));
        boolean hasRelationship = user.getProducts()
                .stream().anyMatch(product1 -> product1.getId().equals(product.getId()));
        if (hasRelationship) {
            return ResponseEntity.badRequest().body("is already in comparison table");
        } else {
            user.getProducts().add(product);
            product.getUsers().add(user);
            userRepository.save(user);
            productRepository.save(product);
        }
        return ResponseEntity.ok("Product has been added to the comparison table.");
    }

    @Override
    public List<ComparisonResponse> getComparisonListBySubCategory(CategoryType categoryType, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        Map<CategoryType, List<ComparisonResponse>> categoryMap = new HashMap<>();
        categoryMap.put(CategoryType.SMARTPHONES, mapper.mapToResponse(comparisonRepository.smartphones(user.getId())));
        categoryMap.put(CategoryType.LAPTOPS, mapper.mapToResponse(comparisonRepository.laptops(user.getId())));
        categoryMap.put(CategoryType.TABLETS, mapper.mapToResponse(comparisonRepository.tablets(user.getId())));
        categoryMap.put(CategoryType.SMARTWATCH, mapper.mapToResponse(comparisonRepository.smartWatch(user.getId())));
        return categoryMap.getOrDefault(categoryType, null);
    }

    @Override
    public void getClear(Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        user.setProducts(null);
        userRepository.save(user);
        userRepository.delete(user);
    }


}
