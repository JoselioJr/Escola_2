package com.joseliojr.Escola_2.dto;

import java.util.UUID;

public class CarteiraDeEstudanteDto {
    private UUID id;
    private String numero;
    private String dataEmissao;
    private String dataValidade;
    private UUID alunoId;

    public CarteiraDeEstudanteDto() {}

    public CarteiraDeEstudanteDto(UUID id, String numero, String dataEmissao, String dataValidade, UUID alunoId) {
        this.id = id;
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.dataValidade = dataValidade;
        this.alunoId = alunoId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public UUID getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(UUID alunoId) {
        this.alunoId = alunoId;
    }
}