package com.joseliojr.Escola_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseliojr.Escola_2.model.Professor;
import com.joseliojr.Escola_2.repository.ProfessorRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public void deleteById(UUID id) {
        if (!professorRepository.existsById(id)) {
            throw new EntityNotFoundException("Professor não encontrado com ID: " + id);
        }
        professorRepository.deleteById(id);
    }

    public Professor update(UUID id, Professor professorDetails) {
        Professor professor = findById(id);

        professor.setNomeCompleto(professorDetails.getNomeCompleto());
        professor.setCpf(professorDetails.getCpf());
        professor.setEmailInstitucional(professorDetails.getEmailInstitucional());
        professor.setTelefone(professorDetails.getTelefone());
        professor.setTitulacao(professorDetails.getTitulacao());
        professor.setAreaAtuacao(professorDetails.getAreaAtuacao());
        professor.setRegimeTrabalho(professorDetails.getRegimeTrabalho());

        return professorRepository.save(professor);
    }

    public Professor findById(UUID id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado com ID: " + id));
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor findByCpf(String cpf) {
        Professor professor = professorRepository.findByCpf(cpf);
        if (professor == null) {
            throw new EntityNotFoundException("Professor não encontrado com CPF: " + cpf);
        }
        return professor;
    }

    public Professor findByEmailInstitucional(String emailInstitucional) {
        Professor professor = professorRepository.findByEmailInstitucional(emailInstitucional);
        if (professor == null) {
            throw new EntityNotFoundException("Professor não encontrado com Email Institucional: " + emailInstitucional);
        }
        return professor;
    }
}
