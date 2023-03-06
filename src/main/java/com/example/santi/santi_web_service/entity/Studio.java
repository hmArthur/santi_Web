package com.example.santi.santi_web_service.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Table(name = "studios")
@Transactional
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String foiVendido = "false";
    private String temGarden =   "false";
    private String temChurrasqueira = "false";

    private String metragemPrivativa;
    
    
    @OneToMany(mappedBy = "studio")
    private List<ImageModel> imagens;

    public Long getId() {
        return this.id;
    }

    public String getFoiVendido() {
        return foiVendido;
    }

    public String getTemChurrasqueira() {
        return temChurrasqueira;
    }

    public void setTemChurrasqueira(String temChurrasqueira) {
        this.temChurrasqueira = temChurrasqueira;
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

    public String getTemGarden() {
        return temGarden;
    }

    public void setTemGarden(String temGarden) {
        this.temGarden = temGarden;
    }

    public void setFoiVendido(String foiVendido) {
        this.foiVendido = foiVendido;
    }

}
