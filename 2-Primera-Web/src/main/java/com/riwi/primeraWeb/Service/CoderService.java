package com.riwi.primeraWeb.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.primeraWeb.Entity.Coder;
import com.riwi.primeraWeb.Repository.CoderRepsitory;

@Service
public class CoderService {
    // @Autowired Registra la inyección de dependencias en Spring boot
    @Autowired
    private CoderRepsitory objCoderRepository;
     
    public List<Coder> findAll(){
        return this.objCoderRepository.findAll();
    }
}
