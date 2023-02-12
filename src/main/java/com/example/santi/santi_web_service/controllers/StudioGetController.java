package com.example.santi.santi_web_service.controllers;



import java.util.List;

import com.example.santi.santi_web_service.entity.Studio;
import com.example.santi.santi_web_service.repository.StudioRepository;
import com.example.santi.santi_web_service.utils.ImageUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studio")
public class StudioGetController {
    @Autowired
    StudioRepository repository;

    @CrossOrigin
    @GetMapping("/{studio}")
	public ResponseEntity<?> downloadImage(@PathVariable String studio){
    
		return ResponseEntity   
                .status(HttpStatus.OK)
				.body(repository.findByNome(studio));
	}


    @CrossOrigin
    @GetMapping()
	public ResponseEntity<?> getAllStudios(){
        List<Studio> studios = repository.findAll();

        studios.forEach(studio -> {
            studio.getImagens().forEach(image -> {
                byte[] imageByte = ImageUtils.decompressImage(image.getImageData());
                image.setImageData(imageByte);
            });
        });

		return ResponseEntity   
                .status(HttpStatus.OK)
				.body(studios);
	}
}
