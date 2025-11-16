package com.joseliojr.Escola_2.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Aluno extends Pessoa {
    @Column(nullable = false)
    private String dataNascimento;

    @Column(nullable = false, unique = true)
    private int matricula;
    
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
    
    @OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
    private CarteiraDeEstudante carteira;
    
    @ManyToMany(mappedBy = "alunos")
    private List<Funcionario> funcionarios;

    public Aluno() {
    }

    public Aluno(String nomeCompleto, String cpf, String emailInstitucional, String telefone,
            String dataNascimento, int matricula) {
        super(nomeCompleto, cpf, emailInstitucional, telefone);
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public CarteiraDeEstudante getCarteira() {
        return carteira;
    }

    public void setCarteira(CarteiraDeEstudante carteira) {
        this.carteira = carteira;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}