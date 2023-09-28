package com.peaksoft.gadgetaruimm6.model.dto.mapper;

public interface Mapper <RQST,ENTITY,RSPNS>{
    ENTITY mapToEntity(RQST rqst);
    RSPNS mapToResponse(ENTITY entity);

}
