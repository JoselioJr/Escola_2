package com.joseliojr.Escola_2.dto;

import java.util.UUID;

public class ProfessorDto {
    private UUID id;
    private String nomeCompleto;
    private String cpf;
    private String emailInstitucional;
    private String telefone;
    private String titulacao;
    private String areaAtuacao;
    private int regimeTrabalho;

    public ProfessorDto() {
    }

    public ProfessorDto(UUID id, String nomeCompleto, String cpf, String emailInstitucional,
            String telefone, String titulacao, String areaAtuacao, int regimeTrabalho) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.emailInstitucional = emailInstitucional;
        this.telefone = telefone;
        this.titulacao = titulacao;
        this.areaAtuacao = areaAtuacao;
        this.regimeTrabalho = regimeTrabalho;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmailInstitucional() {
        return emailInstitucional;
    }

    public void setEmailInstitucional(String emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public int getRegimeTrabalho() {
        return regimeTrabalho;
    }

    public void setRegimeTrabalho(int regimeTrabalho) {
        this.regimeTrabalho = regimeTrabalho;
    }
}
