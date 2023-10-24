package com.peaksoft.gadgetaruimm6.repository;

import com.peaksoft.gadgetaruimm6.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductFilterRepository extends JpaRepository<Product, Long> {

    @Query("""
            SELECT p FROM Product p WHERE
            CAST(p.color as string) IN :colors
            OR CAST(p.memoryRam as string) IN :rams
            OR CAST(p.memory as string) IN :roms
            OR p.price BETWEEN :priceFrom AND :priceTo
            """)
    List<Product> filter(@Param("colors") List<String> colors,
                         @Param("rams") List<String> rams,
                         @Param("roms") List<String> roms,
                         @Param("priceFrom") int priceFrom,
                         @Param("priceTo") int priceTo);

    @Query("""
            SELECT p FROM Product p WHERE
            CAST(p.color as string) IN :colors
            OR CAST(p.memoryRam as string) IN :rams
            OR CAST(p.memory as string) IN :roms
            OR p.price BETWEEN :priceFrom AND :priceTo ORDER BY p.price ASC
            """)
    List<Product> filterAsc(@Param("colors") List<String> colors,
                            @Param("rams") List<String> rams,
                            @Param("roms") List<String> roms,
                            @Param("priceFrom") int priceFrom,
                            @Param("priceTo") int priceTo);

    @Query("""
            SELECT p FROM Product p WHERE
            CAST(p.color AS string) IN :colors
            OR CAST(p.memoryRam as string) IN :rams
            OR CAST(p.memory as string) IN :roms
            OR p.price BETWEEN :priceFrom AND :priceTo ORDER BY p.price DESC
            """)
    List<Product> filterDesc(
                             @Param("colors") List<String> colors,
                             @Param("rams") List<String> rams,
                             @Param("roms") List<String> roms,
                             @Param("priceFrom") int priceFrom,
                             @Param("priceTo") int priceTo);

    @Query("""
            SELECT p FROM Product p WHERE
            CAST(p.color AS string) IN :colors
            OR CAST(p.memoryRam as string) IN :rams
            OR CAST(p.memory as string) IN :roms
            OR p.price BETWEEN :priceFrom AND :priceTo
            ORDER BY p.discount.percent DESC
            """)
    List<Product> filterSale(
                             @Param("colors") List<String> colors,
                             @Param("rams") List<String> rams,
                             @Param("roms") List<String> roms,
                             @Param("priceFrom") int priceFrom,
                             @Param("priceTo") int priceTo);

    @Query("""
            SELECT p FROM Product p WHERE
            p.discount.percent > 50
            ORDER BY p.discount.percent DESC
            """)
    List<Product> filterSaleUp(
                               @Param("colors") List<String> colors,
                               @Param("rams") List<String> rams,
                               @Param("roms") List<String> roms,
                               @Param("priceFrom") int priceFrom,
                               @Param("priceTo") int priceTo);

    @Query("""
            SELECT p FROM Product p where
            CAST(p.color AS string) IN :colors
            OR CAST(p.memoryRam as string) IN :rams
            OR CAST(p.memory as string) IN :roms
            OR p.price BETWEEN :priceFrom AND :priceTo
            ORDER BY CAST(p.releaseDate AS localdate) DESC
            """)
    List<Product> filterRec(
                            @Param("colors") List<String> colors,
                            @Param("rams") List<String> rams,
                            @Param("roms") List<String> roms,
                            @Param("priceFrom") int priceFrom,
                            @Param("priceTo") int priceTo);

    @Query("""
            SELECT p FROM Product p WHERE
            CAST(p.color AS string) IN :colors
            OR CAST(p.memoryRam as string) IN :rams
            OR CAST(p.memory as string) IN :roms
            OR p.price BETWEEN :priceFrom AND :priceTo
            ORDER BY CAST(p.releaseDate AS localdate) DESC
            """)
    List<Product> filterNew(
                            @Param("colors") List<String> colors,
                            @Param("rams") List<String> rams,
                            @Param("roms") List<String> roms,
                            @Param("priceFrom") int priceFrom,
                            @Param("priceTo") int priceTo);


}
