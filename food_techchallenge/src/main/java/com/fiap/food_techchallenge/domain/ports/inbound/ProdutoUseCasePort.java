package com.fiap.food_techchallenge.domain.ports.inbound;

import com.fiap.food_techchallenge.application.adapter.outbound.entity.ProdutoEntity;
import com.fiap.food_techchallenge.domain.domains.Produto;

import java.util.List;

public interface ProdutoUseCasePort {

    Produto executeListar(Long id);
    List<ProdutoEntity> executeListarCategoria(String descricaoCategoria);
    Produto executeSalvar(Produto produto);
    Produto executeAtualizar(Produto produto);
    void executeDeletar(Long id);
}
