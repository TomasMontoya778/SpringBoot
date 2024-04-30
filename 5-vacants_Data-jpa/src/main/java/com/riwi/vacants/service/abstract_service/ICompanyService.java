package com.riwi.vacants.service.abstract_service;

import com.riwi.vacants.service.interfaces.CrudService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;

public interface ICompanyService extends CrudService<CompanyRequest, CompanyResponse, String>{
    public CompanyResponse getById(String id);
}
