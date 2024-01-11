package com.fiap.food_techchallenge.domain.repositories;

import com.fiap.food_techchallenge.domain.models.CategoriaModel;

public interface CategoriaRepository {

    CategoriaModel listarCategoriaById(Long id);

    CategoriaModel listarCategoriaByDescricao(String descricao);
}
