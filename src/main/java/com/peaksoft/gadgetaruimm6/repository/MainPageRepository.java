package com.peaksoft.gadgetaruimm6.repository;

import com.peaksoft.gadgetaruimm6.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainPageRepository extends JpaRepository<Product, Long> {

    @Query("select product from Product  product order by product.discount.percent desc ")
    List<Product> mainPageDiscountProducts();

    @Query("select  product from Product  product where product.releaseDate >= current date - 7 order by product.releaseDate desc ")
    List<Product> mainPageNewProduct();

    @Query("select  product from Product product join product.feedbacks s order by s.evaluation")
    List<Product> mainPageRecommend();
}
