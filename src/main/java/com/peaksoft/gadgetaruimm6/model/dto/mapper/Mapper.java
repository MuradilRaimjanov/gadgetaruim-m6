package com.peaksoft.gadgetaruimm6.model.dto.mapper;

import org.springframework.stereotype.Component;


public interface Mapper <RQST,ENTITY,RSPNS>{
    ENTITY mapToEntity(RQST rqst);
    RSPNS mapToResponse(ENTITY entity);

}
