package com.fiap.food_techchallenge.domain.ports.outbound;

import com.fiap.food_techchallenge.domain.Categoria;

public interface CategoriaAdapterPort {

    Categoria recuperaCategoriaById(Long id);
}
