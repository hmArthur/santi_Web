package com.example.santi.santi_web_service.repository;

import java.util.List;
import java.util.Optional;

import com.example.santi.santi_web_service.entity.Studio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {
    
    @Query("SELECT s FROM Studio s LEFT JOIN FETCH s.imagens i WHERE s.nome = ?1")
    Optional<Studio> findByNome(String nome);


    Page<Studio> findAll(Pageable pageable);
}
