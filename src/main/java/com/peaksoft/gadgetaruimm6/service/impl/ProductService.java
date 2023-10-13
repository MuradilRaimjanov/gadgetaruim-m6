package com.peaksoft.gadgetaruimm6.service.impl;

import com.peaksoft.gadgetaruimm6.exception.NotFoundException;
import com.peaksoft.gadgetaruimm6.exception.ProductNotFoundException;
import com.peaksoft.gadgetaruimm6.model.dto.ProductRequest;
import com.peaksoft.gadgetaruimm6.model.dto.ProductResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.ProductMapper;
import com.peaksoft.gadgetaruimm6.model.entity.Product;
import com.peaksoft.gadgetaruimm6.repository.BrandRepository;
import com.peaksoft.gadgetaruimm6.repository.ProductRepository;
import com.peaksoft.gadgetaruimm6.service.ServiceLayer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService implements ServiceLayer<ProductRequest, ProductResponse> {

    ProductRepository productRepository;
    ProductMapper productMapper;
    BrandRepository brandRepository;

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
        return productRepository.findAll()
                .stream()
                .map(productMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse update(Long id, ProductRequest productRequest) {
        Product allProduct = byId(id);
        allProduct.setWeight(productRequest.getWeight());
        allProduct.setName(productRequest.getName());
        allProduct.setImage(productRequest.getImage());
        allProduct.setPrice(productRequest.getPrice());
        allProduct.setScreen(productRequest.getScreen());
        allProduct.setGuarantee(productRequest.getGuarantee());
        allProduct.setProcessor(productRequest.getProcessor());
        allProduct.setDescription(productRequest.getDescription());
        allProduct.setFileVideo(productRequest.getFileVideo());
        allProduct.setFilePDF(productRequest.getFilePDF());
        allProduct.setGender(productRequest.getGender());
        allProduct.setForm(productRequest.getForm());
        allProduct.setWaterproof(productRequest.getWaterproof());
        allProduct.setWireless(productRequest.getWireless());
        allProduct.setCategoryType(productRequest.getCategoryType());
        allProduct.setColor(productRequest.getColor());
        allProduct.setOs(productRequest.getOs());
        allProduct.setMemory(productRequest.getMemory());
        allProduct.setReleaseDate(LocalDate.from(LocalDate.now()));
        allProduct.setQuantitySimCards(productRequest.getQuantitySimCards());
        allProduct.setArticleNumber(productRequest.getArticleNumber());
        allProduct.setTrackType(productRequest.getTrackType());
        allProduct.setEnginePower(productRequest.getEnginePower());
        allProduct.setEngineType(productRequest.getEngineType());
        allProduct.setSpeedAdjustment(productRequest.getSpeedAdjustment());
        allProduct.setPunningTrack(productRequest.getPunningTrack());
        allProduct.setSlopeOfTheTreadmill(productRequest.getSlopeOfTheTreadmill());
        allProduct.setDiameterOfTheRear(productRequest.getDiameterOfTheRear());
        allProduct.setProgramTraining(productRequest.getProgramTraining());

        switch (productRequest.getSortBy()) {
            case BY_NEW -> {
                allProduct = (Product) productRepository.filterNew(
                        productRequest.getBrandId(),
                        productRequest.getColor(),
                        productRequest.getRam(),
                        productRequest.getRom(),
                        productRequest.getPriceFrom(),
                        productRequest.getPriceTo()
                );
            }
            case BY_ASC -> {
                allProduct = (Product) productRepository.filterAsc(
                        productRequest.getBrandId(),
                        productRequest.getColor(),
                        productRequest.getRam(),
                        productRequest.getRom(),
                        productRequest.getPriceFrom(),
                        productRequest.getPriceTo()
                );
            }
            case BY_DESC -> {
                allProduct = (Product) productRepository.filterDesc(
                        productRequest.getBrandId(),
                        productRequest.getColor(),
                        productRequest.getRam(),
                        productRequest.getRom(),
                        productRequest.getPriceFrom(),
                        productRequest.getPriceTo()
                );
            }
            case BY_SALE -> {
                allProduct = (Product) productRepository.filterSale(
                        productRequest.getBrandId(),
                        productRequest.getColor(),
                        productRequest.getRam(),
                        productRequest.getRom(),
                        productRequest.getPriceFrom(),
                        productRequest.getPriceTo()
                );
            }
            case BY_SALE_UP -> {
                allProduct = (Product) productRepository.filterSaleUp(
                        productRequest.getBrandId(),
                        productRequest.getColor(),
                        productRequest.getRam(),
                        productRequest.getRom(),
                        productRequest.getPriceFrom(),
                        productRequest.getPriceTo()
                );
            }
            case BY_REC -> {
                allProduct = (Product) productRepository.filterRec(
                        productRequest.getBrandId(),
                        productRequest.getColor(),
                        productRequest.getRam(),
                        productRequest.getRom(),
                        productRequest.getPriceFrom(),
                        productRequest.getPriceTo()
                );
            }
            default -> {
                allProduct = (Product) productRepository.filter(
                        productRequest.getBrandId(),
                        productRequest.getColor(),
                        productRequest.getRam(),
                        productRequest.getRom(),
                        productRequest.getPriceFrom(),
                        productRequest.getPriceTo()
                );
            }
        }
        if (allProduct == null) {
            throw new ProductNotFoundException("ProductList is empty!!!");
        } else {
            return productMapper.mapToResponse(productRepository.save(allProduct));
        }
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
        product.setPrice(productRequest.getPrice());
        product.setQuantityOfProducts(product.getQuantityOfProducts());
        productRepository.save(product);
        return productMapper.mapToResponse(product);
    }

    Product byId(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Product with id:" + id + " not found!!!"));
    }


}
