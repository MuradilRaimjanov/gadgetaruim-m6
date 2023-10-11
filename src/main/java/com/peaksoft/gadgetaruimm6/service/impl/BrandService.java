package com.peaksoft.gadgetaruimm6.service.impl;

import com.peaksoft.gadgetaruimm6.exception.NotFoundException;
import com.peaksoft.gadgetaruimm6.model.dto.BrandRequest;
import com.peaksoft.gadgetaruimm6.model.dto.BrandResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.BrandMapper;
import com.peaksoft.gadgetaruimm6.model.entity.Brand;
import com.peaksoft.gadgetaruimm6.repository.BrandRepository;
import com.peaksoft.gadgetaruimm6.service.ServiceLayer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BrandService implements ServiceLayer<BrandRequest, BrandResponse> {

    BrandRepository brandRepository;
    BrandMapper brandMapper;

    @Override
    public BrandResponse save(BrandRequest brandRequest) {
        return brandMapper.mapToResponse(brandRepository.save(brandMapper.mapToEntity(brandRequest)));
    }

    @Override
    public BrandResponse findById(Long id) {
        return brandMapper.mapToResponse(byId(id));
    }

    @Override
    public List<BrandResponse> findAll() {
        return brandRepository.findAll()
                .stream()
                .map(brandMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BrandResponse update(Long id, BrandRequest brandRequest) {
        Brand brands = byId(id);
        brands.setBrandName(brandRequest.getBrandName());
        brands.setImage(brandRequest.getImage());
        brands.setProducts(brandRequest.getProducts());
        return brandMapper.mapToResponse(brandRepository.save(brands));
    }

    @Override
    public BrandResponse delete(Long id) {
        Brand brand = byId(id);
        brandRepository.deleteById(id);
        return brandMapper.mapToResponse(brand);
    }

    @Override
    public BrandResponse setDescription(Long id, BrandRequest brandRequest) {
        return null;
    }

    @Override
    public BrandResponse setPricesAndQuantities(Long id, BrandRequest brandRequest) {
        return null;
    }

    Brand byId(Long id) {
        return brandRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Brand with id:" + id + " not found!!!"));
    }

}
