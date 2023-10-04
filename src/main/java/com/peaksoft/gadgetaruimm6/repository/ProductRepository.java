package com.peaksoft.gadgetaruimm6.repository;

import com.peaksoft.gadgetaruimm6.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

   @Query("""
           SELECT p FROM Product p WHERE
           cast(p.brand as string) IN :brands
           OR cast(p.color as string) IN :colors
           OR p.ram IN :rams
           OR p.rom IN :roms
           OR p.price between :priceFrom and :priceTo
           """)
    List<Product> filterCatalog(@Param("brands") List<String> brands,
                                @Param("colors")List<String> colors,
                                @Param("rams") List<Integer> rams,
                                @Param("roms") List<Integer> roms,
                                @Param("priceFrom") int priceFrom, @Param("priceTo") int priceTo);

}
