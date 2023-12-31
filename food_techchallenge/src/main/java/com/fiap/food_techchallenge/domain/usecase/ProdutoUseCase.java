package com.fiap.food_techchallenge.domain.usecase;


import com.fiap.food_techchallenge.application.adapter.outbound.entity.ProdutoEntity;
import com.fiap.food_techchallenge.domain.domains.Categoria;
import com.fiap.food_techchallenge.domain.domains.Produto;
import com.fiap.food_techchallenge.domain.ports.inbound.ProdutoUseCasePort;
import com.fiap.food_techchallenge.domain.ports.outbound.CategoriaAdapterPort;
import com.fiap.food_techchallenge.domain.ports.outbound.ProdutoAdapterPort;

import java.util.List;

public class ProdutoUseCase implements ProdutoUseCasePort {

    private final ProdutoAdapterPort produtoAdapterPort;
    private final CategoriaAdapterPort categoriaAdapterPort;

    public ProdutoUseCase(ProdutoAdapterPort produtoAdapterPort, CategoriaAdapterPort categoriaAdapterPort) {
        this.produtoAdapterPort = produtoAdapterPort;
        this.categoriaAdapterPort = categoriaAdapterPort;
    }

    @Override
    public Produto executeSalvar(Produto produto) {
        produto.setCategoria(categoriaAdapterPort.listarCategoriaById(produto.getCategoria().getId()));
        return produtoAdapterPort.salvar(produto);
    }

    @Override
    public Produto executeListar(Long id) {
        Produto produto = produtoAdapterPort.listaProduto(id);
        produto.setCategoria(categoriaAdapterPort.listarCategoriaById(produto.getCategoria().getId()));
        return produto;
    }

    @Override
    public List<ProdutoEntity> executeListarCategoria(String descricaoCategoria) {
        Categoria categoria = categoriaAdapterPort.listarCategoriaByDescricao(descricaoCategoria);
        return produtoAdapterPort.listaProdutoCategoria(categoria.getId());
    }

    @Override
    public Produto executeAtualizar(Produto produto) {
        produto.setCategoria(categoriaAdapterPort.listarCategoriaById(produto.getCategoria().getId()));
        return produtoAdapterPort.atualizaProduto(produto);
    }

    @Override
    public void executeDeletar(Long id) {
        produtoAdapterPort.deletaProduto(id);
    }
}
