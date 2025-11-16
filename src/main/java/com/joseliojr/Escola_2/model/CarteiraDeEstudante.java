package com.joseliojr.Escola_2.model;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class CarteiraDeEstudante {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(nullable = false, unique = true)
    private String numero;
    
    @Column(nullable = false)
    private String dataEmissao;
    
    @Column(nullable = false)
    private String dataValidade;
    
    @OneToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public CarteiraDeEstudante() {}

    public CarteiraDeEstudante(String numero, String dataEmissao, String dataValidade) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.dataValidade = dataValidade;
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
