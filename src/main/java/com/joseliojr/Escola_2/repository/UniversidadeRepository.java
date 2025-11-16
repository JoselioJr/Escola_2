package com.joseliojr.Escola_2.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseliojr.Escola_2.model.Universidade;

public interface UniversidadeRepository extends JpaRepository<Universidade, UUID> {
}