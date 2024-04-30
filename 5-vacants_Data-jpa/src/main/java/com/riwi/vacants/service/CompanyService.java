package com.riwi.vacants.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Empresa;
import com.riwi.vacants.entities.Vacante;
import com.riwi.vacants.repository.CompanyRepository;
import com.riwi.vacants.service.abstract_service.ICompanyService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;
import com.riwi.vacants.utils.dto.response.VancanteToCompanyResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {
    @Autowired
    private final CompanyRepository objCompanyRepository;

    @Override
    public CompanyResponse create(CompanyRequest request) {
        Empresa empresa = this.requestEmpresa(request, new Empresa());
        return this.entityToResponse(this.objCompanyRepository.save(empresa));
    }

    @Override
    public void delete(String id) {
        this.objCompanyRepository.deleteById(id);
    }

    @Override
    public CompanyResponse update(String id, CompanyRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
    

    @Override
    public CompanyResponse getById(String id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public Page<CompanyResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        // Iteramos con map cada compañía y la convertimos -> podemos hacerlo con
        // expresión lamda flecha -> o expresión lamda inferencial ::
        // return this.objCompanyRepository.findAll(pagination).map(company ->
        // this.entityToResponse(company));
        return this.objCompanyRepository.findAll(pagination).map(this::entityToResponse);
    }

    // Este método se encarga de convertir un objeto Company a CompanyResponse
    private CompanyResponse entityToResponse(Empresa entity) {
        CompanyResponse response = new CompanyResponse();
        BeanUtils.copyProperties(entity, response);
        /*
         * Mapeamos las vacantes convirtiendo cada una de ellas al DTO de respuesta
         * stream() Convierte una lista en una colección para poder acceder a los
         * métodos map, foreach etc...
         * .collect(Collectors.toList()) Convierte la colección de nuevo a una lista
         */
        response.setVacantes(entity.getVacantes().stream().map(Vacante -> this.vancanteToResponse(Vacante))
                .collect(Collectors.toList()));
        return response;
    }

    private VancanteToCompanyResponse vancanteToResponse(Vacante entity) {
        VancanteToCompanyResponse response = new VancanteToCompanyResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    private Empresa requestEmpresa(CompanyRequest objCompanyRequest, Empresa empresa) {
        BeanUtils.copyProperties(objCompanyRequest, empresa);
        empresa.setVacantes(new ArrayList<>());
        return empresa;
    }
    private Empresa find(String id){
        return this.objCompanyRepository.findById(id).orElseThrow();
    }
    
}
