package com.riwi.vacants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.vacants.service.abstract_service.IVacanteService;
import com.riwi.vacants.utils.dto.request.VacanteRequest;
import com.riwi.vacants.utils.dto.response.VacanteResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/vacantes")
@AllArgsConstructor
public class VacanteController {
    @Autowired
    private final IVacanteService objVacanteService;

    @GetMapping
    public ResponseEntity<Page<VacanteResponse>> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int size){
        return ResponseEntity.ok(this.objVacanteService.getAll(page - 1, size));
    }
    @PostMapping
    public ResponseEntity<VacanteResponse> save(@Validated @RequestBody VacanteRequest objVacanteRequest){
        return ResponseEntity.ok(this.objVacanteService.create(objVacanteRequest));
    }
}
