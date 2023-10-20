package com.fiap.food_techchallenge.domain.ports.inbound;

import com.fiap.food_techchallenge.domain.Produto;

public interface ProdutoUseCasePort {

    Produto execute(Long id);
    Produto execute(Produto produto);
}
