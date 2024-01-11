package com.fiap.food_techchallenge.domain.repositories;

import com.fiap.food_techchallenge.data.entities.ProdutoEntity;
import com.fiap.food_techchallenge.domain.models.ProdutoModel;

import java.util.List;

public interface ProdutoRepository {

    ProdutoModel salvar(ProdutoModel produtoModel);
    ProdutoModel listaProduto(Long id);
    List<ProdutoEntity> listaProdutoCategoria(Long id);
    ProdutoModel atualizaProduto(ProdutoModel produtoModel);
    void deletaProduto(Long id);
}
