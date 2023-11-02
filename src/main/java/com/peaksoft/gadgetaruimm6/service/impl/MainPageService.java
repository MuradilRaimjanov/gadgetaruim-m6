package com.peaksoft.gadgetaruimm6.service.impl;

import com.peaksoft.gadgetaruimm6.model.dto.MainPageResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.FilterMapper;
import com.peaksoft.gadgetaruimm6.repository.MainPageRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class MainPageService {

    MainPageRepository mainPageRepository;
    FilterMapper filterMapper;

    public MainPageResponse mainPage(){
        MainPageResponse mainPageResponse = new MainPageResponse();
        mainPageResponse.setSale(filterMapper.mapToResponse(mainPageRepository.mainPageDiscountProducts()));
        mainPageResponse.setNewItems(filterMapper.mapToResponse(mainPageRepository.mainPageNewProduct()));
        mainPageResponse.setRecommend(filterMapper.mapToResponse(mainPageRepository.mainPageRecommend()));
        return mainPageResponse;
    }
}
