package com.riwi.beautySalon.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.beautySalon.api.dto.request.ServiceRequest;
import com.riwi.beautySalon.api.dto.response.ServiceResponse;
import com.riwi.beautySalon.infrastructure.services.ServiceService;
import com.riwi.beautySalon.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/service")
@AllArgsConstructor
public class ServiceController {
    @Autowired
    private final ServiceService objServiceService;

    @GetMapping
    public ResponseEntity<Page<ServiceResponse>> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size, @RequestHeader(required = false) SortType sortType){
        if (Objects.isNull(sortType)) {
            sortType = SortType.NONE;
        }
        return ResponseEntity.ok(this.objServiceService.getAll(page-1, size, sortType));
    }
    @PostMapping
    public ResponseEntity<ServiceResponse> save(@Validated @RequestBody ServiceRequest serviceRequest){
        return ResponseEntity.ok(this.objServiceService.create(serviceRequest));
    }

}
