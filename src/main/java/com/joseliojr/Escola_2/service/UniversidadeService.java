package com.joseliojr.Escola_2.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseliojr.Escola_2.model.Universidade;
import com.joseliojr.Escola_2.repository.UniversidadeRepository;

@Service
public class UniversidadeService {
    
    @Autowired
    private UniversidadeRepository universidadeRepository;
    
    public List<Universidade> findAll() {
        return universidadeRepository.findAll();
    }
    
    public Universidade findById(UUID id) {
        return universidadeRepository.findById(id).orElse(null);
    }
    
    public Universidade save(Universidade universidade) {
        return universidadeRepository.save(universidade);
    }
    
    public void deleteById(UUID id) {
        universidadeRepository.deleteById(id);
    }
}