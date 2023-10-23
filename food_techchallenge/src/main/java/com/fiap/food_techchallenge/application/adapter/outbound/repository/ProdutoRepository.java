package com.fiap.food_techchallenge.application.adapter.outbound.repository;

import com.fiap.food_techchallenge.application.adapter.outbound.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findAllByCategoriaId(Long id);
}
