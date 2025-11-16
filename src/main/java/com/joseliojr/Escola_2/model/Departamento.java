package com.joseliojr.Escola_2.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sigla;

    @Column(nullable = false)
    private String centro;

    @Column(nullable = false)
    private String emailContato;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String localizacao;
    
    @ManyToOne
    @JoinColumn(name = "universidade_id")
    private Universidade universidade;
    
    @OneToMany(mappedBy = "departamento")
    private List<Professor> professores;
    
    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> funcionarios;
    
    @OneToMany(mappedBy = "departamento")
    private List<Aluno> alunos;
    
    @ManyToOne
    @JoinColumn(name = "chefe_departamento_id")
    private Professor chefeDepartamento;

    public Departamento() {
    }

    public Departamento(String nome, String sigla, String centro, String emailContato, String telefone, String localizacao) {
        this.nome = nome;
        this.sigla = sigla;
        this.centro = centro;
        this.emailContato = emailContato;
        this.telefone = telefone;
        this.localizacao = localizacao;
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

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public Universidade getUniversidade() {
        return universidade;
    }

    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Professor getChefeDepartamento() {
        return chefeDepartamento;
    }

    public void setChefeDepartamento(Professor chefeDepartamento) {
        this.chefeDepartamento = chefeDepartamento;
    }
}
