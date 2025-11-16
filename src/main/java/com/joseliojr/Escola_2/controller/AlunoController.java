package com.joseliojr.Escola_2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.joseliojr.Escola_2.dto.AlunoDto;
import com.joseliojr.Escola_2.dto.DtoConverter;
import com.joseliojr.Escola_2.service.AlunoService;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public AlunoDto createAluno(@RequestBody AlunoDto alunoDto){
        return DtoConverter.toDto(alunoService.save(DtoConverter.toEntity(alunoDto)));
    }

    @PutMapping("/{id}")
    public AlunoDto updateAluno(@PathVariable UUID id, @RequestBody AlunoDto alunoDetails){
        return DtoConverter.toDto(alunoService.update(id, DtoConverter.toEntity(alunoDetails)));
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable UUID id){
        alunoService.deleteById(id);
    }

    @GetMapping
    public List<AlunoDto> getAll(){
        return DtoConverter.toAlunoDto(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public AlunoDto findById(@PathVariable UUID id){
        return DtoConverter.toDto(alunoService.findById(id));
    }
    
    @GetMapping("/cpf/{cpf}")
    public AlunoDto findByCpf(@PathVariable String cpf){
        return DtoConverter.toDto(alunoService.findByCpf(cpf));
    }

    @GetMapping("/matricula/{matricula}")
    public AlunoDto findByMatricula(@PathVariable int matricula){
        return DtoConverter.toDto(alunoService.findByMatricula(matricula));
    }

    @GetMapping("/email/{emailInstitucional}")
    public AlunoDto findByEmail(@PathVariable String emailInstitucional){
        return DtoConverter.toDto(alunoService.findByEmailInstitucional(emailInstitucional));
    }
}
