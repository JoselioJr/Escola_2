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

import com.joseliojr.Escola_2.dto.DepartamentoDto;
import com.joseliojr.Escola_2.dto.DtoConverter;
import com.joseliojr.Escola_2.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping
    public DepartamentoDto createDepartamento(@RequestBody DepartamentoDto departamentoDto){
        return DtoConverter.toDto(departamentoService.save(DtoConverter.toEntity(departamentoDto)));
    }

    @PutMapping("/{id}")
    public DepartamentoDto updateDepartamento(@PathVariable UUID id, @RequestBody DepartamentoDto departamentoDetails){
        return DtoConverter.toDto(departamentoService.update(id, DtoConverter.toEntity(departamentoDetails)));
    }

    @DeleteMapping("/{id}")
    public void deleteDepartamento(@PathVariable UUID id){
        departamentoService.deleteById(id);
    }

    @GetMapping
    public List<DepartamentoDto> getAll(){
        return DtoConverter.toDepartamentoDto(departamentoService.findAll());
    }

    @GetMapping("/{id}")
    public DepartamentoDto findById(@PathVariable UUID id){
        return DtoConverter.toDto(departamentoService.findById(id));
    }

    @GetMapping("/nome/{nome}")
    public DepartamentoDto findByNome(@PathVariable String nome){
        return DtoConverter.toDto(departamentoService.findByNome(nome));
    }
}
