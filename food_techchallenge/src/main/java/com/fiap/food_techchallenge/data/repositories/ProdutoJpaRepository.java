package com.fiap.food_techchallenge.data.repositories;

import com.fiap.food_techchallenge.data.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findAllByCategoriaId(Long id);
}
