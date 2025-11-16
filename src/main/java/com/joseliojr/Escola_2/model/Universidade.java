package com.joseliojr.Escola_2.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class Universidade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String sigla;
    
    @Column(nullable = false)
    private String tipo;
    
    @OneToMany(mappedBy = "universidade")
    private List<Departamento> departamentos;

    public Universidade() {}

    public Universidade(String nome, String sigla, String tipo) {
        this.nome = nome;
        this.sigla = sigla;
        this.tipo = tipo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
}
