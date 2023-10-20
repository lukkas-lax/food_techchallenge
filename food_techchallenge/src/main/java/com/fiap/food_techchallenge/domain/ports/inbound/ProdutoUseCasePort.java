package com.fiap.food_techchallenge.domain.ports.inbound;

import com.fiap.food_techchallenge.domain.Produto;

public interface ProdutoUseCasePort {

    Produto executeListar(Long id);
    Produto executeSalvar(Produto produto);
    Produto executeAtualizar(Produto produto);
    void executeDeletar(Long id);
}
