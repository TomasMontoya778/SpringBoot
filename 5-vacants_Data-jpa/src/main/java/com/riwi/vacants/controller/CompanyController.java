package com.riwi.vacants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.vacants.service.abstract_service.ICompanyService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {
    @Autowired
    private final ICompanyService objCompanyService;

    @GetMapping
    public ResponseEntity<Page<CompanyResponse>> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int size){
            return ResponseEntity.ok(this.objCompanyService.getAll((page - 1), size));
    }
    @PostMapping
    public ResponseEntity<CompanyResponse> save(@RequestBody CompanyRequest company){
        return ResponseEntity.ok(this.objCompanyService.create(company));
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<CompanyResponse> getById(@PathVariable String id){
        return ResponseEntity.ok(this.objCompanyService.getById(id));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.objCompanyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
