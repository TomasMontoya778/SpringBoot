package com.riwi.tallerApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.tallerApiRest.entities.Evento;

public interface EventRepository extends JpaRepository<Evento, String>{

}
