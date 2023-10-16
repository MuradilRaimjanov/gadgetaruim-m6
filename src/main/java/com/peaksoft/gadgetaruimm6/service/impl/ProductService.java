package com.peaksoft.gadgetaruimm6.service.impl;

import com.peaksoft.gadgetaruimm6.exception.NotFoundException;
import com.peaksoft.gadgetaruimm6.model.dto.ProductRequest;
import com.peaksoft.gadgetaruimm6.model.dto.ProductResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.ProductMapper;
import com.peaksoft.gadgetaruimm6.model.entity.Product;
import com.peaksoft.gadgetaruimm6.model.enums.SortBy;
import com.peaksoft.gadgetaruimm6.repository.ProductRepository;
import com.peaksoft.gadgetaruimm6.service.ServiceLayer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService implements ServiceLayer<ProductRequest, ProductResponse> {


    ProductRepository productRepository;
    ProductMapper productMapper;

    @Override
    public ProductResponse save(ProductRequest productRequest) {
        return productMapper.mapToResponse(productRepository.save(productMapper.mapToEntity(productRequest)));
    }

    @Override
    public ProductResponse findById(Long id) {
        return productMapper.mapToResponse(byId(id));
    }

    @Override
    public List<ProductResponse> findAll() {
        return null;
    }

    public List<ProductResponse> findAllProducts(SortBy sortBy) {

        List<Product> products = new ArrayList<>();
        if (sortBy.equals(SortBy.BY_NEW)) {
            products = productRepository.filterNew();
        } else if (sortBy.equals(SortBy.BY_ASC)) {
            products = productRepository.filterAsc();
        } else if (sortBy.equals(SortBy.BY_DESC)) {
            products = productRepository.filterDesc();
        } else {
            productRepository.filterRec();
        }
        return products
                .stream()
                .map(productMapper::mapToResponse)
                .collect(Collectors.toList());
    }


    @Override
    public ProductResponse update(Long id, ProductRequest productRequest) {
        Product oldProduct = byId(id);
        oldProduct.setWeight(productRequest.getWeight());
        oldProduct.setName(productRequest.getName());
        oldProduct.setImage(productRequest.getImage());
        oldProduct.setPrice(Integer.parseInt(productRequest.getPrice()));
        oldProduct.setScreen(productRequest.getScreen());
        oldProduct.setGuarantee(productRequest.getGuarantee());
        oldProduct.setProcessor(productRequest.getProcessor());
        oldProduct.setDescription(productRequest.getDescription());
        oldProduct.setFileVideo(productRequest.getFileVideo());
        oldProduct.setFilePDF(productRequest.getFilePDF());
        oldProduct.setGender(productRequest.getGender());
        oldProduct.setForm(productRequest.getForm());
        oldProduct.setWaterproof(productRequest.getWaterproof());
        oldProduct.setWireless(productRequest.getWireless());
        oldProduct.setCategoryType(productRequest.getCategoryType());
        oldProduct.setColor(productRequest.getColor());
        oldProduct.setOs(productRequest.getOs());
        oldProduct.setMemory(productRequest.getMemory().get(id.intValue()));
        oldProduct.setReleaseDate(LocalDate.from(LocalDate.now()));
        oldProduct.setQuantitySimCards(productRequest.getQuantitySimCards());
        oldProduct.setArticleNumber(productRequest.getArticleNumber());
        oldProduct.setTrackType(productRequest.getTrackType());
        oldProduct.setEnginePower(productRequest.getEnginePower());
        oldProduct.setEngineType(productRequest.getEngineType());
        oldProduct.setSpeedAdjustment(productRequest.getSpeedAdjustment());
        oldProduct.setPunningTrack(productRequest.getPunningTrack());
        oldProduct.setSlopeOfTheTreadmill(productRequest.getSlopeOfTheTreadmill());
        oldProduct.setDiameterOfTheRear(productRequest.getDiameterOfTheRear());
        oldProduct.setProgramTraining(productRequest.getProgramTraining());
        return productMapper.mapToResponse(productRepository.save(oldProduct));
    }


    @Override
    public ProductResponse delete(Long id) {
        Product product = byId(id);
        productRepository.deleteById(id);
        return productMapper.mapToResponse(product);
    }

    @Override
    public ProductResponse setDescription(Long id, ProductRequest productRequest) {
        Product product = byId(id);
        product.setFileVideo(productRequest.getFileVideo());
        product.setFilePDF(productRequest.getFilePDF());
        product.setDescription(productRequest.getDescription());
        productRepository.save(product);
        return productMapper.mapToResponse(product);
    }

    @Override
    public ProductResponse setPricesAndQuantities(Long id, ProductRequest productRequest) {
        Product product = byId(id);
        product.setPrice(Integer.parseInt(productRequest.getPrice()));
        product.setQuantityOfProducts(product.getQuantityOfProducts());
        productRepository.save(product);
        return productMapper.mapToResponse(product);
    }

    Product byId(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Product with id:" + id + " not found!!!"));
    }


}
