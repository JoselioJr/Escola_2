package com.joseliojr.Escola_2.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseliojr.Escola_2.dto.DtoConverter;
import com.joseliojr.Escola_2.dto.FuncionarioDto;
import com.joseliojr.Escola_2.service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public FuncionarioDto createFuncionario(@RequestBody FuncionarioDto funcionarioDto){
        return DtoConverter.toDto(funcionarioService.save(DtoConverter.toEntity(funcionarioDto)));
    }

    @PutMapping("/{id}")
    public FuncionarioDto updateFuncionario(@PathVariable UUID id, @RequestBody FuncionarioDto funcionarioDetails){
        return DtoConverter.toDto(funcionarioService.update(id, DtoConverter.toEntity(funcionarioDetails)));
    }

    @DeleteMapping("/{id}")
    public void deleteFuncionario(@PathVariable UUID id){
        funcionarioService.deleteById(id);
    }

    @GetMapping
    public List<FuncionarioDto> getAll(){
        return DtoConverter.toFuncionarioDto(funcionarioService.findAll());
    }

    @GetMapping("/{id}")
    public FuncionarioDto findById(@PathVariable UUID id){
        return DtoConverter.toDto(funcionarioService.findById(id));
    }

    @GetMapping("/nome/{nomeCompleto}")
    public FuncionarioDto findByNomeCompleto(@PathVariable String nomeCompleto){
        return DtoConverter.toDto(funcionarioService.findByNomeCompleto(nomeCompleto));
    }

    @GetMapping("/cpf/{cpf}")
    public FuncionarioDto findByCpf(@PathVariable String cpf){
        return DtoConverter.toDto(funcionarioService.findByCpf(cpf));
    }

    @GetMapping("/email/{emailInstitucional}")
    public FuncionarioDto findByEmail(@PathVariable String emailInstitucional){
        return DtoConverter.toDto(funcionarioService.findByEmailInstitucional(emailInstitucional));
    }
}
