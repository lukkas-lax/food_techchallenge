package com.fiap.food_techchallenge.domain.ports.outbound;

import com.fiap.food_techchallenge.domain.domains.Categoria;

public interface CategoriaAdapterPort {

    Categoria listarCategoriaById(Long id);

    Categoria listarCategoriaByDescricao(String descricao);
}
