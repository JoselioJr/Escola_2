package com.joseliojr.Escola_2.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseliojr.Escola_2.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
    Professor findByNomeCompleto(String nomeCompleto);
    Professor findByCpf(String cpf);
    Professor findByEmailInstitucional(String emailInstitucional);
}
