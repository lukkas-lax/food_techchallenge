package com.fiap.food_techchallenge.domain.ports.inbound;

import com.fiap.food_techchallenge.domain.Categoria;

public interface CategoriaUseCasePort {

    Categoria execute(Long id);
}
