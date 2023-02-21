package com.example.santi.santi_web_service.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "image_table")
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Lob
    @Column(name = "imagedata",length = 100000)
    private byte[] imageData;

    @ManyToOne(fetch = FetchType.LAZY)
    private Studio studio;

    public byte[] getImageData() {
        return this.imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public ImageModel() {}

    public ImageModel(String name, String type, byte[] picByte) {
		this.name = name;
		this.type = type;
		this.imageData = picByte;
	}

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

}