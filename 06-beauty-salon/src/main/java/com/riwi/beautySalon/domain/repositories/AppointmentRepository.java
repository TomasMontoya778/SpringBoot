package com.riwi.beautySalon.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.riwi.beautySalon.domain.entities.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    @Query(value = "select a from appointment join fetch a.client c where c.id = :id_client")
    Optional<Appointment> findByClientId(Long id_client);
}
