package com.joseliojr.Escola_2.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseliojr.Escola_2.model.Aluno;
import com.joseliojr.Escola_2.repository.AlunoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deleteById(UUID id) {
        if (!alunoRepository.existsById(id)) {
            throw new EntityNotFoundException("Aluno não encontrado com ID: " + id);
        }
        alunoRepository.deleteById(id);
    }

    public Aluno update(UUID id, Aluno alunoDetails) {
        Aluno aluno = findById(id);

        aluno.setNomeCompleto(alunoDetails.getNomeCompleto());
        aluno.setCpf(alunoDetails.getCpf());
        aluno.setMatricula(alunoDetails.getMatricula());
        aluno.setEmailInstitucional(alunoDetails.getEmailInstitucional());
        aluno.setTelefone(alunoDetails.getTelefone());
        aluno.setDataNascimento(alunoDetails.getDataNascimento());

        return alunoRepository.save(aluno);
    }

    public Aluno findById(UUID id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado com ID: " + id));
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno findByCpf(String cpf) {
        Aluno aluno = alunoRepository.findByCpf(cpf);
        if (aluno == null) {
            throw new EntityNotFoundException("Aluno não encontrado com CPF: " + cpf);
        }
        return aluno;
    }

    public Aluno findByMatricula(int matricula) {
        Aluno aluno = alunoRepository.findByMatricula(matricula);
        if (aluno == null) {
            throw new EntityNotFoundException("Aluno não encontrado com Matrícula: " + matricula);
        }
        return aluno;
    }

    public Aluno findByEmailInstitucional(String emailInstitucional) {
        Aluno aluno = alunoRepository.findByEmailInstitucional(emailInstitucional);
        if (aluno == null) {
            throw new EntityNotFoundException("Aluno não encontrado com Email Institucional: " + emailInstitucional);
        }
        return aluno;
    }

}
