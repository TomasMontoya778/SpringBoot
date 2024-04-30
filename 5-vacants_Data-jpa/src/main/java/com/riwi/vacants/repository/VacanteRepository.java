package com.riwi.vacants.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.vacants.entities.Vacante;
import java.util.List;


@Repository
public interface VacanteRepository extends JpaRepository<Vacante, Long>{
    List<Vacante> findByTitulo(String titulo);
}
