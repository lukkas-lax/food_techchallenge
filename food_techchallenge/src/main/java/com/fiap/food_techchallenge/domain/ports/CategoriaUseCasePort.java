package com.fiap.food_techchallenge.domain.ports;

import com.fiap.food_techchallenge.domain.models.CategoriaModel;

public interface CategoriaUseCasePort {
    CategoriaModel execute(Long id);

    CategoriaModel execute(String descricao);
}


