package com.joseliojr.Escola_2.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.joseliojr.Escola_2.model.CarteiraDeEstudante;
import com.joseliojr.Escola_2.service.CarteiraDeEstudanteService;

@RestController
@RequestMapping("/carteiras")
public class CarteiraDeEstudanteController {
    
    @Autowired
    private CarteiraDeEstudanteService carteiraService;
    
    @GetMapping
    public List<CarteiraDeEstudante> getAllCarteiras() {
        return carteiraService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CarteiraDeEstudante> getCarteiraById(@PathVariable UUID id) {
        CarteiraDeEstudante carteira = carteiraService.findById(id);
        return carteira != null ? ResponseEntity.ok(carteira) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public CarteiraDeEstudante createCarteira(@RequestBody CarteiraDeEstudante carteira) {
        return carteiraService.save(carteira);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CarteiraDeEstudante> updateCarteira(@PathVariable UUID id, @RequestBody CarteiraDeEstudante carteira) {
        if (carteiraService.findById(id) != null) {
            carteira.setId(id);
            return ResponseEntity.ok(carteiraService.save(carteira));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarteira(@PathVariable UUID id) {
        if (carteiraService.findById(id) != null) {
            carteiraService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}