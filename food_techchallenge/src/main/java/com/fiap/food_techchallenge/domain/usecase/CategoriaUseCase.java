package com.fiap.food_techchallenge.domain.usecase;

import com.fiap.food_techchallenge.domain.domains.Categoria;
import com.fiap.food_techchallenge.domain.ports.inbound.CategoriaUseCasePort;
import com.fiap.food_techchallenge.domain.ports.outbound.CategoriaAdapterPort;

public class CategoriaUseCase implements CategoriaUseCasePort {

    private CategoriaAdapterPort categoriaAdapterPort;
    @Override
    public Categoria execute(Long id) {
        return categoriaAdapterPort.listarCategoriaById(id);
    }

    @Override
    public Categoria execute(String descricao) {
        return categoriaAdapterPort.listarCategoriaByDescricao(descricao);
    }
}
