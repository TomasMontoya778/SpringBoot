package com.riwi.beautySalon.infrastructure.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.beautySalon.api.dto.request.ServiceRequest;
import com.riwi.beautySalon.api.dto.response.ServiceResponse;
import com.riwi.beautySalon.domain.entities.ServicesEntity;
import com.riwi.beautySalon.domain.repositories.ServiceRepository;
import com.riwi.beautySalon.infrastructure.abstract_services.IServiceService;
import com.riwi.beautySalon.utils.enums.SortType;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ServiceService implements IServiceService{
    @Autowired
    private final ServiceRepository objServiceRepository;

    @Override
    public ServiceResponse create(ServiceRequest request) {
        ServicesEntity servicesEntity = this.requestToEntity(request, new ServicesEntity());
        return this.entityToResponse(this.objServiceRepository.save(servicesEntity));
    }
    private ServiceResponse entityToResponse(ServicesEntity service){

        return ServiceResponse.builder()
        .id(service.getId())
        .name(service.getName()).
        description(service.getDescription()).
        price(service.getPrice()).build();
    }
    private ServicesEntity requestToEntity(ServiceRequest serviceRequest, ServicesEntity servicesEntity){
        BeanUtils.copyProperties(serviceRequest, servicesEntity);
        return servicesEntity;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ServiceResponse get(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    // private ServicesEntity find (Long id){
    //     return this.objServiceRepository.findById(id).orElseThrow(() -> );
    // }

    @Override
    public Page<ServiceResponse> getAll(int page, int size, SortType sort) {
        if (page < 0) page = 0;
        PageRequest pagination = null;
        switch (sort) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }
        return this.objServiceRepository.findAll(pagination).map(this::entityToResponse);
    }
    @Override
    public ServiceResponse update(ServiceRequest request, Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
