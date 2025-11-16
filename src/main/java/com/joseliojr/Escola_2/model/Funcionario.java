package com.joseliojr.Escola_2.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Funcionario extends Pessoa {

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private String tipoVinculo;
    
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
    
    @ManyToMany(mappedBy = "funcionarios")
    private List<Professor> professores;
    
    @ManyToMany
    @JoinTable(
        name = "aluno_funcionario",
        joinColumns = @JoinColumn(name = "funcionario_id"),
        inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private List<Aluno> alunos;

    public Funcionario() {
    }

    public Funcionario(String nomeCompleto, String cpf, String emailInstitucional,
            String telefone, String cargo, String tipoVinculo) {
        super(nomeCompleto, cpf, emailInstitucional, telefone);
        this.cargo = cargo;
        this.tipoVinculo = tipoVinculo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(String tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
