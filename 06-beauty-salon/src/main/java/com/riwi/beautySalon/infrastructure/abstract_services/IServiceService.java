package com.riwi.beautySalon.infrastructure.abstract_services;

import com.riwi.beautySalon.api.dto.request.ServiceRequest;
import com.riwi.beautySalon.api.dto.response.ServiceResponse;

public interface IServiceService extends CrudService<ServiceRequest, ServiceResponse, Long> {
    public final String FIELD_BY_SORT = "price";
}
