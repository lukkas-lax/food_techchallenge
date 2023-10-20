package com.fiap.food_techchallenge.domain.ports.outbound;

import com.fiap.food_techchallenge.domain.Produto;

public interface ProdutoAdapterPort {

    Produto salvar(Produto produto);
    Produto listaProduto(Long id);
    Produto atualizaProduto(Produto produto);
    void deletaProduto(Long id);
}
