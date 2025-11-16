package com.joseliojr.Escola_2.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.joseliojr.Escola_2.model.Aluno;
import com.joseliojr.Escola_2.model.Departamento;
import com.joseliojr.Escola_2.model.Funcionario;
import com.joseliojr.Escola_2.model.Professor;

public class DtoConverter {

    public static AlunoDto toDto(Aluno aluno) {
        return new AlunoDto(
            aluno.getId(),
            aluno.getNomeCompleto(),
            aluno.getCpf(),
            aluno.getEmailInstitucional(),
            aluno.getTelefone(),
            aluno.getDataNascimento(),
            aluno.getMatricula()
        );
    }

    public static Aluno toEntity(AlunoDto dto) {
        Aluno aluno = new Aluno();
        aluno.setId(dto.getId());
        aluno.setNomeCompleto(dto.getNomeCompleto());
        aluno.setCpf(dto.getCpf());
        aluno.setEmailInstitucional(dto.getEmailInstitucional());
        aluno.setTelefone(dto.getTelefone());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setMatricula(dto.getMatricula());
        return aluno;
    }

    public static ProfessorDto toDto(Professor professor) {
        return new ProfessorDto(
            professor.getId(),
            professor.getNomeCompleto(),
            professor.getCpf(),
            professor.getEmailInstitucional(),
            professor.getTelefone(),
            professor.getTitulacao(),
            professor.getAreaAtuacao(),
            professor.getRegimeTrabalho()
        );
    }

    public static Professor toEntity(ProfessorDto dto) {
        Professor professor = new Professor();
        professor.setId(dto.getId());
        professor.setNomeCompleto(dto.getNomeCompleto());
        professor.setCpf(dto.getCpf());
        professor.setEmailInstitucional(dto.getEmailInstitucional());
        professor.setTelefone(dto.getTelefone());
        professor.setTitulacao(dto.getTitulacao());
        professor.setAreaAtuacao(dto.getAreaAtuacao());
        professor.setRegimeTrabalho(dto.getRegimeTrabalho());
        return professor;
    }

    public static FuncionarioDto toDto(Funcionario funcionario) {
        return new FuncionarioDto(
            funcionario.getId(),
            funcionario.getNomeCompleto(),
            funcionario.getCpf(),
            funcionario.getEmailInstitucional(),
            funcionario.getTelefone(),
            funcionario.getCargo(),
            funcionario.getTipoVinculo()
        );
    }

    public static Funcionario toEntity(FuncionarioDto dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(dto.getId());
        funcionario.setNomeCompleto(dto.getNomeCompleto());
        funcionario.setCpf(dto.getCpf());
        funcionario.setEmailInstitucional(dto.getEmailInstitucional());
        funcionario.setTelefone(dto.getTelefone());
        funcionario.setCargo(dto.getCargo());
        funcionario.setTipoVinculo(dto.getTipoVinculo());
        return funcionario;
    }

    public static DepartamentoDto toDto(Departamento departamento) {
        return new DepartamentoDto(
            departamento.getId(),
            departamento.getNome(),
            departamento.getSigla(),
            departamento.getCentro(),
            departamento.getChefeDepartamento() != null ? departamento.getChefeDepartamento().getId() : null,
            departamento.getEmailContato(),
            departamento.getTelefone(),
            departamento.getLocalizacao()
        );
    }

    public static Departamento toEntity(DepartamentoDto dto) {
        Departamento departamento = new Departamento();
        departamento.setId(dto.getId());
        departamento.setNome(dto.getNome());
        departamento.setSigla(dto.getSigla());
        departamento.setCentro(dto.getCentro());
        departamento.setEmailContato(dto.getEmailContato());
        departamento.setTelefone(dto.getTelefone());
        departamento.setLocalizacao(dto.getLocalizacao());
        return departamento;
    }

    public static List<AlunoDto> toAlunoDto(List<Aluno> alunos) {
        return alunos.stream().map(DtoConverter::toDto).collect(Collectors.toList());
    }

    public static List<ProfessorDto> toProfessorDto(List<Professor> professores) {
        return professores.stream().map(DtoConverter::toDto).collect(Collectors.toList());
    }

    public static List<FuncionarioDto> toFuncionarioDto(List<Funcionario> funcionarios) {
        return funcionarios.stream().map(DtoConverter::toDto).collect(Collectors.toList());
    }

    public static List<DepartamentoDto> toDepartamentoDto(List<Departamento> departamentos) {
        return departamentos.stream().map(DtoConverter::toDto).collect(Collectors.toList());
    }
}