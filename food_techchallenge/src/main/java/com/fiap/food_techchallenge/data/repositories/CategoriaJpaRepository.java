package com.fiap.food_techchallenge.data.repositories;

import com.fiap.food_techchallenge.data.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, Long> {
    Object findByDescricao(String descricao);
}
