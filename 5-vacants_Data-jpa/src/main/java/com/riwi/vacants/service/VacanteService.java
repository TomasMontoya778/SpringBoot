package com.riwi.vacants.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Empresa;
import com.riwi.vacants.entities.Vacante;
import com.riwi.vacants.repository.VacanteRepository;
import com.riwi.vacants.service.abstract_service.IVacanteService;
import com.riwi.vacants.utils.dto.request.VacanteRequest;
import com.riwi.vacants.utils.dto.response.CompanyToVacanteResponse;
import com.riwi.vacants.utils.dto.response.VacanteResponse;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class VacanteService implements IVacanteService{
    @Autowired
    private final VacanteRepository objVacanteRepository;
    @Override
    public VacanteResponse create(VacanteRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Page<VacanteResponse> getAll(int page, int size) {
        if (page > 0) {
            page = 0; 
        }
        PageRequest objPageRequest = PageRequest.of(page, size);
        return this.objVacanteRepository.findAll(objPageRequest).map(this::entityToResponse);
    }
    private VacanteResponse entityToResponse (Vacante vacante){
        VacanteResponse response = new VacanteResponse();
        BeanUtils.copyProperties(vacante, response);
        // response.setEmpresa(vacante.getEmpresa());
        return response;
    }
    private CompanyToVacanteResponse companyToVacante(Empresa empresa){
        CompanyToVacanteResponse response = new CompanyToVacanteResponse();
        BeanUtils.copyProperties(empresa, response);
        return response;
    }

    @Override
    public VacanteResponse update(Long id, VacanteRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

}
