package com.example.santi.santi_web_service.controllers;



import java.util.ArrayList;
import java.util.List;

import com.example.santi.santi_web_service.dto.studioDto;
import com.example.santi.santi_web_service.entity.Studio;
import com.example.santi.santi_web_service.repository.StudioRepository;
import com.example.santi.santi_web_service.utils.ImageUtils;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/studio")

public class StudioGetController {
    @Autowired
    StudioRepository repository;

    @CrossOrigin
    @GetMapping("/{studio}")
	public ResponseEntity<?> downloadImage(@PathVariable String studio){
        Studio studioN = repository.findByNome(studio).get();
        studioN.getImagens().forEach((im) -> {
            byte[] image = ImageUtils.decompressImage(im.getImageData());
            im.setImageData(image);
        });
       

		return ResponseEntity   
                .status(HttpStatus.OK)
				.body(studioN);
	}


    @CrossOrigin
    @GetMapping("/pagina/{pagina}")
	public ResponseEntity<?> getAllStudios(@PathVariable String pagina){
        Pageable firstPageWithEight = PageRequest.of(Integer.parseInt(pagina), 8);
        
        
        Page<Studio> studios = repository.findAll(firstPageWithEight);
        List<studioDto> studiosd = new ArrayList(8);
    
        studios.forEach(studio -> {
            studio.getImagens().size();
            if (studio.getImagens().size() > 0)  {
            studiosd.add(new studioDto(studio.getNome(),
             studio.getFoiVendido(), studio.getTemChurrasqueira(), 
             studio.getTemGarden(), studio.getMetragemPrivativa(),
              ImageUtils.decompressImage(studio.getImagens().get(0).getImageData())));
            } else {
                studiosd.add(new studioDto(studio.getNome(),
                studio.getFoiVendido(), studio.getTemChurrasqueira(), 
                studio.getTemGarden(), studio.getMetragemPrivativa(),
                null));
            }
        });

        
       
    

		return ResponseEntity   
                .status(HttpStatus.OK)
				.body(studiosd);
	}
}
