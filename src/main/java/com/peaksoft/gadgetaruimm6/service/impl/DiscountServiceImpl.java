package com.peaksoft.gadgetaruimm6.service.impl;

import com.peaksoft.gadgetaruimm6.model.dto.DiscountRequest;
import com.peaksoft.gadgetaruimm6.model.dto.DiscountResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.DiscountMapper;
import com.peaksoft.gadgetaruimm6.model.entity.Discount;
import com.peaksoft.gadgetaruimm6.repository.DiscountRepository;
import com.peaksoft.gadgetaruimm6.service.DiscountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DiscountServiceImpl implements DiscountService {

    DiscountMapper discountMapper;
    DiscountRepository discountRepository;

    @Override
    public DiscountResponse save(DiscountRequest discountRequest) {
        Discount discount = discountMapper.mapToEntity(discountRequest);
        discountRepository.save(discount);
        return discountMapper.mapToResponse(discount);
    }

    @Override
    public DiscountResponse update(Long id, DiscountRequest discountRequest) {
        Discount discount = discountRepository.findById(id).orElseThrow(()-> new RuntimeException("The discount not found"));
        discount.setPercent(discountRequest.getPercent());
        discount.setStart(discountRequest.getDateOfStart());
        discount.setFinish(discountRequest.getDateOfEnd());
        discountRepository.save(discount);
        return discountMapper.mapToResponse(discount);
    }

    @Override
    public String delete(Long id) {
        Discount discount = discountRepository.findById(id).orElseThrow(()-> new RuntimeException("The discount not found"));
        discountRepository.delete(discount);
        return "The discount successfully deleted";
    }
}
