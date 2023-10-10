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
           cast(p.brand as string) IN :brands
           OR cast(p.color as string) IN :colors
           OR p.ram IN :rams
           OR p.rom IN :roms
           OR p.price between :priceFrom and :priceTo
           """)
    List<Product> filter(@Param("brands") List<String> brands,
                         @Param("colors")List<String> colors,
                         @Param("rams") List<Integer> rams,
                         @Param("roms") List<Integer> roms,
                         @Param("priceFrom") int priceFrom,
                         @Param("priceTo") int priceTo);

    @Query("""
           SELECT p FROM Product p WHERE
           cast(p.brand as string) IN :brands
           OR cast(p.color as string) IN :colors
           OR p.ram IN :rams
           OR p.rom IN :roms
           OR p.price BETWEEN :priceFrom AND :priceTo ORDER BY p.price ASC
           """)
    List<Product> filterAsc(@Param("brands") List<String> brands,
                         @Param("colors")List<String> colors,
                         @Param("rams") List<Integer> rams,
                         @Param("roms") List<Integer> roms,
                         @Param("priceFrom") int priceFrom,
                         @Param("priceTo") int priceTo);

    @Query("""
           SELECT p FROM Product p WHERE
           cast(p.brand as string) IN :brands
           OR cast(p.color as string) IN :colors
           OR p.ram IN :rams
           OR p.rom IN :roms
           OR p.price BETWEEN :priceFrom AND :priceTo ORDER BY p.price DESC
           """)
    List<Product> filterDesc(@Param("brands") List<String> brands,
                         @Param("colors")List<String> colors,
                         @Param("rams") List<Integer> rams,
                         @Param("roms") List<Integer> roms,
                         @Param("priceFrom") int priceFrom,
                         @Param("priceTo") int priceTo);

    @Query("""
           SELECT p FROM Product p WHERE
           cast(p.brand as string) IN :brands
           OR cast(p.color as string) IN :colors
           OR p.ram IN :rams
           OR p.rom IN :roms
           OR p.price between :priceFrom and :priceTo
           ORDER BY p.discount.percent DESC
           """)
    List<Product> filterSale(@Param("brands") List<String> brands,
                         @Param("colors")List<String> colors,
                         @Param("rams") List<Integer> rams,
                         @Param("roms") List<Integer> roms,
                         @Param("priceFrom") int priceFrom,
                         @Param("priceTo") int priceTo);

    @Query("""
           SELECT p FROM Product p WHERE
           p.discount.percent > 50
           ORDER BY p.discount.percent DESC
           """)
    List<Product> filterSaleUp(@Param("brands") List<String> brands,
                            @Param("colors")List<String> colors,
                            @Param("rams") List<Integer> rams,
                            @Param("roms") List<Integer> roms,
                            @Param("priceFrom") int priceFrom,
                            @Param("priceTo") int priceTo);

    @Query("""
           SELECT p FROM Product p where
           cast(p.brand as string) IN :brands
           OR cast(p.color as string) IN :colors
           OR p.ram IN :rams
           OR p.rom IN :roms
           OR p.price between :priceFrom and :priceTo
           ORDER BY cast(p.releaseDate as localdate) DESC
           """)
    List<Product> filterRec(@Param("brands") List<String> brands,
                               @Param("colors")List<String> colors,
                               @Param("rams") List<Integer> rams,
                               @Param("roms") List<Integer> roms,
                               @Param("priceFrom") int priceFrom,
                               @Param("priceTo") int priceTo);

    @Query("""
           SELECT p FROM Product p WHERE
           cast(p.brand as string) IN :brands
           OR cast(p.color as string) IN :colors
           OR p.ram IN :rams
           OR p.rom IN :roms
           OR p.price between :priceFrom and :priceTo
           ORDER BY cast(p.releaseDate as localdate) DESC
           """)
    List<Product> filterNew(@Param("brands") List<String> brands,
                            @Param("colors")List<String> colors,
                            @Param("rams") List<Integer> rams,
                            @Param("roms") List<Integer> roms,
                            @Param("priceFrom") int priceFrom,
                            @Param("priceTo") int priceTo);


}
