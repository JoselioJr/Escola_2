package com.joseliojr.Escola_2.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.joseliojr.Escola_2.model.Universidade;
import com.joseliojr.Escola_2.service.UniversidadeService;

@RestController
@RequestMapping("/universidades")
public class UniversidadeController {
    
    @Autowired
    private UniversidadeService universidadeService;
    
    @GetMapping
    public List<Universidade> getAllUniversidades() {
        return universidadeService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Universidade> getUniversidadeById(@PathVariable UUID id) {
        Universidade universidade = universidadeService.findById(id);
        return universidade != null ? ResponseEntity.ok(universidade) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public Universidade createUniversidade(@RequestBody Universidade universidade) {
        return universidadeService.save(universidade);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Universidade> updateUniversidade(@PathVariable UUID id, @RequestBody Universidade universidade) {
        if (universidadeService.findById(id) != null) {
            universidade.setId(id);
            return ResponseEntity.ok(universidadeService.save(universidade));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversidade(@PathVariable UUID id) {
        if (universidadeService.findById(id) != null) {
            universidadeService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}