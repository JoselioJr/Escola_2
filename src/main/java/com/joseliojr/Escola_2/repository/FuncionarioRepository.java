package com.joseliojr.Escola_2.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseliojr.Escola_2.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {
    Funcionario findByNomeCompleto(String nomeCompleto);
    Funcionario findByCpf(String cpf);
    Funcionario findByEmailInstitucional(String emailInstitucional);
}
