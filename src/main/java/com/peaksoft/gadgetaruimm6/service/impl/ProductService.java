package com.peaksoft.gadgetaruimm6.service.impl;

import com.peaksoft.gadgetaruimm6.exception.NotFoundException;
import com.peaksoft.gadgetaruimm6.model.dto.ProductRequest;
import com.peaksoft.gadgetaruimm6.model.dto.ProductResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.ProductMapper;
import com.peaksoft.gadgetaruimm6.model.entity.Brand;
import com.peaksoft.gadgetaruimm6.model.entity.Product;
import com.peaksoft.gadgetaruimm6.model.enums.SortBy;
import com.peaksoft.gadgetaruimm6.repository.BrandRepository;
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
    BrandRepository brandRepository;

    @Override
    public ProductResponse save(ProductRequest productRequest) {
        return null;
    }

    public ProductResponse saveProduct(Long brandId, ProductRequest productRequest) {
        Brand brand = brandRepository.findById(brandId).get();
        Product product = productMapper.mapToEntity(productRequest);
        product.setBrand(brand);
        return productMapper.mapToResponse(productRepository.save(product));
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
//        try {
//            for (Product product : productRepository.findAll()) {
//                if (product.getSortBy().equals(sortBy)) {
//                    products.add(product);
//                }
//            }
//        } catch (NotFoundException e) {
//            System.out.println("метод не работает");
//        }
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
        oldProduct.setScreen(productRequest.getScreen());
        oldProduct.setGuarantee(productRequest.getGuarantee());
        oldProduct.setProcessor(productRequest.getProcessor());
        oldProduct.setDescription(productRequest.getDescription());
        oldProduct.setForm(productRequest.getForm());
        oldProduct.setCategoryType(productRequest.getCategoryType());
        oldProduct.setColor(productRequest.getColor());
        oldProduct.setOs(productRequest.getOs());
        oldProduct.setPrice(productRequest.getPrice());
        oldProduct.setMemory(productRequest.getMemory());
        oldProduct.setReleaseDate(LocalDate.from(LocalDate.now()));
        oldProduct.setQuantitySimCards(productRequest.getQuantitySimCards());
        oldProduct.setEnginePower(productRequest.getEnginePower());
        return productMapper.mapToResponse(productRepository.save(oldProduct));
    }


    @Override
    public ProductResponse delete(Long id) {
        Product product = byId(id);
        productRepository.deleteById(id);
        return productMapper.mapToResponse(product);
    }

    public ProductResponse setDescription(Long id, ProductRequest productRequest) {
//        Product product = productRepository.findById(id).get();
//        productMapper.mapToEntity(productRequest);
        Product product=byId(id);
        product.setFilePDF(productRequest.getFilePDF());
        product.setFileVideo(product.getFileVideo());
        product.setImage(productRequest.getImage());
        product.setDescription(productRequest.getDescription());
        return productMapper.mapToResponse(productRepository.save(product));
    }

    public ProductResponse setPricesAndQuantities(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).get();
        productMapper.mapToEntity(productRequest);
        product.setPrice(productRequest.getPrice());
        product.setQuantityOfProducts(productRequest.getQuantityOfProducts());
        return productMapper.mapToResponse(productRepository.save(product));
    }

    Product byId(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Product with id:" + id + " not found!!!"));
    }


}
