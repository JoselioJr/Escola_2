package com.joseliojr.Escola_2.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseliojr.Escola_2.model.Departamento;
import com.joseliojr.Escola_2.repository.DepartamentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento save(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public void deleteById(UUID id) {
        if (!departamentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Departamento não encontrado com ID: " + id);
        }
        departamentoRepository.deleteById(id);
    }

    public Departamento update(UUID id, Departamento departamentoDetails) {
        Departamento departamento = findById(id);

        departamento.setNome(departamentoDetails.getNome());
        departamento.setSigla(departamentoDetails.getSigla());
        departamento.setCentro(departamentoDetails.getCentro());
        departamento.setChefeDepartamento(departamentoDetails.getChefeDepartamento());
        departamento.setEmailContato(departamentoDetails.getEmailContato());
        departamento.setTelefone(departamentoDetails.getTelefone());
        departamento.setLocalizacao(departamentoDetails.getLocalizacao());

        return departamentoRepository.save(departamento);
    }

    public Departamento findById(UUID id) {
        return departamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departamento não encontrado com ID: " + id));
    }

    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    public Departamento findByNome(String nome) {
        Departamento departamento = departamentoRepository.findByNome(nome);
        if (departamento == null) {
            throw new EntityNotFoundException("Departamento não encontrado com Nome: " + nome);
        }
        return departamento;
    }
}
