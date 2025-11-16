package com.joseliojr.Escola_2.dto;

import java.util.UUID;

public class UniversidadeDto {
    private UUID id;
    private String nome;
    private String sigla;
    private String tipo;

    public UniversidadeDto() {}

    public UniversidadeDto(UUID id, String nome, String sigla, String tipo) {
        this.id = id;
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
}