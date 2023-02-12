package com.example.santi.santi_web_service.repository;


import java.util.Optional;

import com.example.santi.santi_web_service.entity.ImageModel;
import com.example.santi.santi_web_service.entity.Studio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    Optional<ImageModel> findByName(String name);
    Optional<ImageModel> findByStudio(Studio studio);
}
