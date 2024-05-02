package com.riwi.vacants.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Empresa;
import com.riwi.vacants.entities.Vacante;
import com.riwi.vacants.repository.CompanyRepository;
import com.riwi.vacants.repository.VacanteRepository;
import com.riwi.vacants.service.abstract_service.IVacanteService;
import com.riwi.vacants.utils.dto.request.VacanteRequest;
import com.riwi.vacants.utils.dto.response.CompanyToVacanteResponse;
import com.riwi.vacants.utils.dto.response.VacanteResponse;
import com.riwi.vacants.utils.enums.StateVacant;
import com.riwi.vacants.utils.exceptions.IdNotFoundExceptions;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class VacanteService implements IVacanteService{
    @Autowired
    private final VacanteRepository objVacanteRepository;
    @Autowired
    private final CompanyRepository objCompanyRepository;
    @Override
    public VacanteResponse create(VacanteRequest request) {
        /*
         * Nos aseguramos que el id de la empresa esté dentro del request sea válido
         */
        Empresa objCompany = this.objCompanyRepository.findById(request.getCompany_id()).orElseThrow(() -> new IdNotFoundExceptions("company"));
        // Convertimos el request a la entidad
        Vacante objVacante = this.requestToEntity(request, new Vacante());
        // agregamos la empresa encontrada
        objVacante.setEmpresa(objCompany);
        return this.entityToResponse(this.objVacanteRepository.save(objVacante));
    }

    private Vacante requestToEntity(VacanteRequest request, Vacante vacante){
        BeanUtils.copyProperties(request, vacante);
        vacante.setStatus(StateVacant.ACTIVE);
        return vacante;
    }
    
    private VacanteResponse entityToResponse (Vacante vacante){
        VacanteResponse response = new VacanteResponse();
        BeanUtils.copyProperties(vacante, response);
        // Crear la instacia del dto de la empresa dentro de vacantes
        CompanyToVacanteResponse objCompanyToVacanteResponse = new CompanyToVacanteResponse();
        BeanUtils.copyProperties(vacante.getEmpresa(), objCompanyToVacanteResponse);
        // Agregamos el dto de respuesta de la empresa en la respuesta general
        response.setEmpresa(objCompanyToVacanteResponse);
        return response;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Page<VacanteResponse> getAll(int page, int size) {
        if (page > 0) page = 0;
        PageRequest objPageRequest = PageRequest.of(page, size);
        /*
         * Obtenemos todas las vacantes de la BD y las mapeamos al dto de respuesta
         */
        return this.objVacanteRepository.findAll(objPageRequest).map(this::entityToResponse);
    }
    

    @Override
    public VacanteResponse getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VacanteResponse update(Long id, VacanteRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

}
