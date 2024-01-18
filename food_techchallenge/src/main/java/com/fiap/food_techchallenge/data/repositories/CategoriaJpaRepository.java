package com.fiap.food_techchallenge.data.repositories;

import com.fiap.food_techchallenge.data.entities.CategoriaEntity;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
@Hidden
public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, Long> {
    Object findByDescricao(String descricao);
}
