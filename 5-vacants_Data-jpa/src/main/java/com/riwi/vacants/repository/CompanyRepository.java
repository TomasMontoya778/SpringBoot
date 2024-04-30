package com.riwi.vacants.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.vacants.entities.Empresa;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Empresa, String>{
    List<Empresa> findByName(String name);
}
