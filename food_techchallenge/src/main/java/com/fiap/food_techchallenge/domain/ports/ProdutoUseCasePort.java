package com.fiap.food_techchallenge.domain.ports;

import com.fiap.food_techchallenge.data.entities.ProdutoEntity;
import com.fiap.food_techchallenge.domain.models.ProdutoModel;

import java.util.List;

public interface ProdutoUseCasePort {

    ProdutoModel executeListar(Long id);
    List<ProdutoEntity> executeListarCategoria(String descricaoCategoria);
    ProdutoModel executeSalvar(ProdutoModel produtoModel);
    ProdutoModel executeAtualizar(ProdutoModel produtoModel);
    void executeDeletar(Long id);
}
