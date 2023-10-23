package com.fiap.food_techchallenge.domain.ports.outbound;

import com.fiap.food_techchallenge.application.adapter.outbound.entity.ProdutoEntity;
import com.fiap.food_techchallenge.domain.Produto;

import java.util.List;

public interface ProdutoAdapterPort {

    Produto salvar(Produto produto);
    Produto listaProduto(Long id);
    List<ProdutoEntity> listaProdutoCategoria(Long id);
    Produto atualizaProduto(Produto produto);
    void deletaProduto(Long id);
}
