package com.peaksoft.gadgetaruimm6.repository;

import com.peaksoft.gadgetaruimm6.model.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("""
            SELECT p FROM Product p WHERE 
             p.price BETWEEN :priceFrom AND :priceTo ORDER BY p.price ASC
            """)
    List<Product> filterAsc();


    @Query("""
            SELECT p FROM Product p WHERE 
            p.price BETWEEN :priceFrom AND :priceTo ORDER BY p.price DESC
            """)
    List<Product> filterDesc();

    @Query("""
            SELECT p FROM Product p
            ORDER BY CAST(p.releaseDate AS localdate) DESC
            """)
    List<Product> filterRec();

    @Query("""
            SELECT p FROM Product p
            ORDER BY CAST(p.releaseDate AS localdate) DESC
            """)
    List<Product> filterNew();

}
