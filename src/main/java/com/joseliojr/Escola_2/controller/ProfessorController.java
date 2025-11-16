package com.joseliojr.Escola_2.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseliojr.Escola_2.dto.ProfessorDto;
import com.joseliojr.Escola_2.dto.DtoConverter;
import com.joseliojr.Escola_2.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ProfessorDto createProfessor(@RequestBody ProfessorDto professorDto){
        return DtoConverter.toDto(professorService.save(DtoConverter.toEntity(professorDto)));
    }

    @PutMapping("/{id}")
    public ProfessorDto updateProfessor(@PathVariable UUID id, @RequestBody ProfessorDto professorDetails){
        return DtoConverter.toDto(professorService.update(id, DtoConverter.toEntity(professorDetails)));
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable UUID id){
        professorService.deleteById(id);
    }

    @GetMapping
    public List<ProfessorDto> getAll(){
        return DtoConverter.toProfessorDto(professorService.findAll());
    }

    @GetMapping("/{id}")
    public ProfessorDto findById(@PathVariable UUID id){
        return DtoConverter.toDto(professorService.findById(id));
    }

    @GetMapping("/cpf/{cpf}")
    public ProfessorDto findByCpf(@PathVariable String cpf){
        return DtoConverter.toDto(professorService.findByCpf(cpf));
    }

    @GetMapping("/email/{emailInstitucional}")
    public ProfessorDto findByEmail(@PathVariable String emailInstitucional){
        return DtoConverter.toDto(professorService.findByEmailInstitucional(emailInstitucional));
    }
}
