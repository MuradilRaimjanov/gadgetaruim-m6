package com.peaksoft.gadgetaruimm6.repository;

import com.peaksoft.gadgetaruimm6.model.entity.Brand;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BrandRepository extends JpaRepository<Brand,Long> {

}
