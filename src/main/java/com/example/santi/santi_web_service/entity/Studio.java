package com.example.santi.santi_web_service.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "studios")
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private Boolean foiVendido = false;
    private Boolean temGarden = false;

    private String metragemPrivativa;

    @OneToMany(mappedBy = "studio", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ImageModel> imagens;

    public Boolean getFoiVendido() {
        return foiVendido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ImageModel> getImagens() {
        return this.imagens;
    }

    public String getMetragemPrivativa() {
        return metragemPrivativa;
    }

    public void setMetragemPrivativa(String metragemPrivativa) {
        this.metragemPrivativa = metragemPrivativa;
    }

    public Boolean getTemGarden() {
        return temGarden;
    }

    public void setTemGarden(Boolean temGarden) {
        this.temGarden = temGarden;
    }

    public void setFoiVendido(Boolean foiVendido) {
        this.foiVendido = foiVendido;
    }

}
