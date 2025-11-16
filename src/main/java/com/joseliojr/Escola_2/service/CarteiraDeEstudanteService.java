package com.joseliojr.Escola_2.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseliojr.Escola_2.model.CarteiraDeEstudante;
import com.joseliojr.Escola_2.repository.CarteiraDeEstudanteRepository;

@Service
public class CarteiraDeEstudanteService {
    
    @Autowired
    private CarteiraDeEstudanteRepository carteiraRepository;
    
    public List<CarteiraDeEstudante> findAll() {
        return carteiraRepository.findAll();
    }
    
    public CarteiraDeEstudante findById(UUID id) {
        return carteiraRepository.findById(id).orElse(null);
    }
    
    public CarteiraDeEstudante save(CarteiraDeEstudante carteira) {
        return carteiraRepository.save(carteira);
    }
    
    public void deleteById(UUID id) {
        carteiraRepository.deleteById(id);
    }
}