package com.joseliojr.Escola_2.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseliojr.Escola_2.model.Funcionario;
import com.joseliojr.Escola_2.repository.FuncionarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deleteById(UUID id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Funcionário não encontrado com ID: " + id);
        }
        funcionarioRepository.deleteById(id);
    }

    public Funcionario update(UUID id, Funcionario funcionarioDetails) {
        Funcionario funcionario = findById(id);

        funcionario.setNomeCompleto(funcionarioDetails.getNomeCompleto());
        funcionario.setCpf(funcionarioDetails.getCpf());
        funcionario.setEmailInstitucional(funcionarioDetails.getEmailInstitucional());
        funcionario.setTelefone(funcionarioDetails.getTelefone());
        funcionario.setCargo(funcionarioDetails.getCargo());
        funcionario.setTipoVinculo(funcionarioDetails.getTipoVinculo());

        return funcionarioRepository.save(funcionario);
    }

    public Funcionario findById(UUID id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com ID: " + id));
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario findByNomeCompleto(String nomeCompleto) {
        Funcionario funcionario = funcionarioRepository.findByNomeCompleto(nomeCompleto);
        if (funcionario == null) {
            throw new EntityNotFoundException("Funcionário não encontrado com Nome Completo: " + nomeCompleto);
        }
        return funcionario;
    }

    public Funcionario findByCpf(String cpf) {
        Funcionario funcionario = funcionarioRepository.findByCpf(cpf);
        if (funcionario == null) {
            throw new EntityNotFoundException("Funcionário não encontrado com CPF: " + cpf);
        }
        return funcionario;
    }

    public Funcionario findByEmailInstitucional(String emailInstitucional) {
        Funcionario funcionario = funcionarioRepository.findByEmailInstitucional(emailInstitucional);
        if (funcionario == null) {
            throw new EntityNotFoundException("Funcionário não encontrado com Email Institucional: " + emailInstitucional);
        }
        return funcionario;
    }
}
