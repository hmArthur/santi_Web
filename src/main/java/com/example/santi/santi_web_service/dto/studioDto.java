package com.example.santi.santi_web_service.dto;

import java.nio.file.attribute.AclEntryFlag;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Data

public class studioDto {
    private Long id;
    private String nome;
    private Boolean foiVendido;
    private Boolean temGarden;
    private Boolean temChurrasqueira;
    private String metragemPrivativa;
    private byte[] imagem;

    public studioDto(String nome2, Boolean foiVendido2, Boolean temChurrasqueira2, Boolean temGarden2, String metragemPrivativa2,
            byte[] imageByte) {
        this.setNome(nome2);
        this.setFoiVendido(foiVendido2);
        this.setTemChurrasqueira(temChurrasqueira2);
        this.setMetragemPrivativa(metragemPrivativa2);
        this.setTemGarden(temGarden2);
        this.setImagem(imageByte);
    }

    public String getMetragemPrivativa() {
        return metragemPrivativa;
    }

    public void setMetragemPrivativa(String metragemPrivativa) {
        this.metragemPrivativa = metragemPrivativa;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Boolean getTemChurrasqueira() {
        return temChurrasqueira;
    }

    public void setTemChurrasqueira(Boolean temChurrasqueira) {
        this.temChurrasqueira = temChurrasqueira;
    }

    public Boolean getTemGarden() {
        return temGarden;
    }

    public void setTemGarden(Boolean temGarden) {
        this.temGarden = temGarden;
    }

    public Boolean getFoiVendido() {
        return foiVendido;
    }

    public void setFoiVendido(Boolean foiVendido) {
        this.foiVendido = foiVendido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
}
