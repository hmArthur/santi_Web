package com.example.santi.santi_web_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

import com.example.santi.santi_web_service.entity.ImageModel;
import com.example.santi.santi_web_service.entity.Studio;
import com.example.santi.santi_web_service.repository.ImageRepository;
import com.example.santi.santi_web_service.repository.StudioRepository;
import com.example.santi.santi_web_service.utils.ImageUtils;
import com.fasterxml.jackson.core.format.InputAccessor.Std;

@Service
public class StorageService {

    @Autowired
    private ImageRepository repository;

    @Autowired
    private StudioRepository studioRepo;

    public String uploadImage(MultipartFile file, String studio) throws IOException {
        System.out.println(file.getBytes().length);
        System.out.println(ImageUtils.compressImage(file.getBytes()).length);

        ImageModel imageData = new ImageModel(file.getOriginalFilename(), file.getContentType(), ImageUtils.compressImage(file.getBytes()));

        try {
            Studio newStudio = studioRepo.findByNome(studio).get();
            imageData.setStudio(newStudio);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        repository.save(imageData);
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return "";
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageModel> dbImageData = repository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}