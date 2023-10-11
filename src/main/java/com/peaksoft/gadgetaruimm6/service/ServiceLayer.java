package com.peaksoft.gadgetaruimm6.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceLayer<RQST, RSNPS> {
    RSNPS save(RQST rqst);

    RSNPS findById(Long id);

    List<RSNPS> findAll();

    RSNPS update(Long id, RQST rqst);

    RSNPS delete(Long id);

    RSNPS setDescription(Long id, RQST rqst);

    RSNPS setPricesAndQuantities(Long id, RQST rqst);


}
