package com.fiap.food_techchallenge.domain.usecase;


import com.fiap.food_techchallenge.domain.Produto;
import com.fiap.food_techchallenge.domain.ports.inbound.ProdutoUseCasePort;
import com.fiap.food_techchallenge.domain.ports.outbound.CategoriaAdapterPort;
import com.fiap.food_techchallenge.domain.ports.outbound.ProdutoAdapterPort;

public class ProdutoUseCase implements ProdutoUseCasePort {

    private final ProdutoAdapterPort produtoAdapterPort;
    private final CategoriaAdapterPort categoriaAdapterPort;

    public ProdutoUseCase(ProdutoAdapterPort produtoAdapterPort, CategoriaAdapterPort categoriaAdapterPort) {
        this.produtoAdapterPort = produtoAdapterPort;
        this.categoriaAdapterPort = categoriaAdapterPort;
    }

    @Override
    public Produto execute(Produto produto) {
        produto.setCategoria(categoriaAdapterPort.recuperaCategoriaById(produto.getCategoria().getId()));
        return produtoAdapterPort.salvar(produto);
    }
}
