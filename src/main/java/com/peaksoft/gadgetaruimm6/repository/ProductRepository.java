package com.peaksoft.gadgetaruimm6.repository;

import com.peaksoft.gadgetaruimm6.model.entity.Product;
import com.peaksoft.gadgetaruimm6.model.enums.Color;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("""
            SELECT p FROM Product p WHERE
            CAST(p.brand as string) IN :brands
            OR CAST(p.color as string) IN :colors
            OR CAST(p.memoryRam as string) IN :rams
            OR CAST(p.memory as string) IN :roms
            OR p.price BETWEEN :priceFrom AND :priceTo
            """)
    List<Product> filter(@Param("brands") Long brands,
                         @Param("colors") Color colors,
                         @Param("rams") String rams,
                         @Param("roms") String roms,
                         @Param("priceFrom") int priceFrom,
                         @Param("priceTo") int priceTo);

    @Query("""
            SELECT p FROM Product p WHERE
            CAST(p.brand as string) IN :brands
            OR CAST(p.color as string) IN :colors
            OR CAST(p.memoryRam as string) IN :rams
            OR CAST(p.memory as string) IN :roms
            OR p.price BETWEEN :priceFrom AND :priceTo ORDER BY p.price ASC
            """)
    List<Product> filterAsc(@Param("brands") Long brands,
                            @Param("colors") Color colors,
                            @Param("rams") String rams,
                            @Param("roms") String roms,
                            @Param("priceFrom") int priceFrom,
                            @Param("priceTo") int priceTo);

    @Query("""
            SELECT p FROM Product p WHERE
            CAST(p.brand AS string) IN :brands
            OR CAST(p.color AS string) IN :colors
            OR CAST(p.memoryRam as string) IN :rams
            OR CAST(p.memory as string) IN :roms
            OR p.price BETWEEN :priceFrom AND :priceTo ORDER BY p.price DESC
            """)
    List<Product> filterDesc(@Param("brands") Long brands,
                             @Param("colors") Color colors,
                             @Param("rams") String rams,
                             @Param("roms") String roms,
                             @Param("priceFrom") int priceFrom,
                             @Param("priceTo") int priceTo);

    @Query("""
            SELECT p FROM Product p WHERE
            CAST(p.brand AS string) IN :brands
            OR CAST(p.color AS string) IN :colors
            OR CAST(p.memoryRam as string) IN :rams
            OR CAST(p.memory as string) IN :roms
            OR p.price BETWEEN :priceFrom AND :priceTo
            ORDER BY p.discount.percent DESC
            """)
    List<Product> filterSale(@Param("brands") Long brands,
                             @Param("colors") Color colors,
                             @Param("rams") String rams,
                             @Param("roms") String roms,
                             @Param("priceFrom") int priceFrom,
                             @Param("priceTo") int priceTo);

    @Query("""
            SELECT p FROM Product p WHERE
            p.discount.percent > 50
            ORDER BY p.discount.percent DESC
            """)
    List<Product> filterSaleUp(@Param("brands") Long brands,
                               @Param("colors") Color colors,
                               @Param("rams") String rams,
                               @Param("roms") String roms,
                               @Param("priceFrom") int priceFrom,
                               @Param("priceTo") int priceTo);

    @Query("""
            SELECT p FROM Product p where
            CAST(p.brand AS string) IN :brands
            OR CAST(p.color AS string) IN :colors
            OR CAST(p.memoryRam as string) IN :rams
            OR CAST(p.memory as string) IN :roms
            OR p.price BETWEEN :priceFrom AND :priceTo
            ORDER BY CAST(p.releaseDate AS localdate) DESC
            """)
    List<Product> filterRec(@Param("brands") Long brands,
                            @Param("colors") Color colors,
                            @Param("rams") String rams,
                            @Param("roms") String roms,
                            @Param("priceFrom") int priceFrom,
                            @Param("priceTo") int priceTo);

    @Query("""
            SELECT p FROM Product p WHERE
            CAST(p.brand AS string) IN :brands
            OR CAST(p.color AS string) IN :colors
            OR CAST(p.memoryRam as string) IN :rams
            OR CAST(p.memory as string) IN :roms
            OR p.price BETWEEN :priceFrom AND :priceTo
            ORDER BY CAST(p.releaseDate AS localdate) DESC
            """)
    List<Product> filterNew(@Param("brands") Long brands,
                            @Param("colors") Color colors,
                            @Param("rams") String rams,
                            @Param("roms") String roms,
                            @Param("priceFrom") int priceFrom,
                            @Param("priceTo") int priceTo);

}
