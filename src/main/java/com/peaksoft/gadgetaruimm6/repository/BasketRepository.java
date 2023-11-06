package com.peaksoft.gadgetaruimm6.repository;

import com.peaksoft.gadgetaruimm6.model.entity.Basket;
import com.peaksoft.gadgetaruimm6.model.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public interface BasketRepository extends JpaRepository<Basket, Long> {

    @Query("SELECT p FROM Product p JOIN p.basket basket WHERE basket.id=:id")
    List<Product> getProductsByBasketId(@Param("id") Long id, Pageable pageable);
}
