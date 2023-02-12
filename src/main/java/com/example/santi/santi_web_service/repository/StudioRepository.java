package com.example.santi.santi_web_service.repository;

import java.util.Optional;

import com.example.santi.santi_web_service.entity.Studio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {
    Optional<Studio> findByNome(String nome);
}
