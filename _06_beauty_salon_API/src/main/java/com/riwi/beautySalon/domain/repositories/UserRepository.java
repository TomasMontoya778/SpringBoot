package com.riwi.beautySalon.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.beautySalon.domain.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    public Optional<User> findByusername(String username);
}
