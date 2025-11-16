package com.joseliojr.Escola_2.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Professor extends Pessoa{
    @Column(nullable = false)
    private String titulacao;

    @Column(nullable = false)
    private String areaAtuacao;

    @Column(nullable = false)
    private int regimeTrabalho;
    
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
    
    @OneToMany(mappedBy = "professor")
    private List<Aluno> alunos;
    
    @ManyToMany
    @JoinTable(
        name = "professor_funcionario",
        joinColumns = @JoinColumn(name = "professor_id"),
        inverseJoinColumns = @JoinColumn(name = "funcionario_id")
    )
    private List<Funcionario> funcionarios;

    public Professor() {
    }
    
    public Professor(String nomeCompleto, String cpf, String emailInstitucional, String telefone,
            String titulacao, String areaAtuacao, int regimeTrabalho) {
        super(nomeCompleto, cpf, emailInstitucional, telefone);
        this.titulacao = titulacao;
        this.areaAtuacao = areaAtuacao;
        this.regimeTrabalho = regimeTrabalho;
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
