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
    private String foiVendido;
    private String temGarden;
    private String temChurrasqueira;
    private String metragemPrivativa;
    private byte[] imagem;

    public studioDto(String nome2, String foiVendido2, String temChurrasqueira2, String temGarden2, String metragemPrivativa2,
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

    public String getTemChurrasqueira() {
        return temChurrasqueira;
    }

    public void setTemChurrasqueira(String temChurrasqueira) {
        this.temChurrasqueira = temChurrasqueira;
    }

    public String getTemGarden() {
        return temGarden;
    }

    public void setTemGarden(String temGarden) {
        this.temGarden = temGarden;
    }

    public String getFoiVendido() {
        return foiVendido;
    }

    public void setFoiVendido(String foiVendido) {
        this.foiVendido = foiVendido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
}
