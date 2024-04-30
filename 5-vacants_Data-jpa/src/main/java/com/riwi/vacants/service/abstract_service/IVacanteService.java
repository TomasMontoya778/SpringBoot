package com.riwi.vacants.service.abstract_service;

import com.riwi.vacants.service.interfaces.CrudService;
import com.riwi.vacants.utils.dto.request.VacanteRequest;
import com.riwi.vacants.utils.dto.response.VacanteResponse;

public interface IVacanteService extends CrudService<VacanteRequest, VacanteResponse, Long>{

}
