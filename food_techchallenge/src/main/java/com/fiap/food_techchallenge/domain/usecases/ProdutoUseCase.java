package com.fiap.food_techchallenge.domain.usecases;


import com.fiap.food_techchallenge.data.entities.ProdutoEntity;
import com.fiap.food_techchallenge.domain.models.CategoriaModel;
import com.fiap.food_techchallenge.domain.models.ProdutoModel;
import com.fiap.food_techchallenge.domain.ports.ProdutoUseCasePort;
import com.fiap.food_techchallenge.domain.repositories.CategoriaRepository;
import com.fiap.food_techchallenge.domain.repositories.ProdutoRepository;

import java.util.List;

public class ProdutoUseCase implements ProdutoUseCasePort {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoUseCase(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public ProdutoModel executeSalvar(ProdutoModel produtoModel) {
        produtoModel.setCategoriaModel(categoriaRepository.listarCategoriaById(produtoModel.getCategoriaModel().getId()));
        return produtoRepository.salvar(produtoModel);
    }

    @Override
    public ProdutoModel executeListar(Long id) {
        ProdutoModel produtoModel = produtoRepository.listaProduto(id);
        produtoModel.setCategoriaModel(categoriaRepository.listarCategoriaById(produtoModel.getCategoriaModel().getId()));
        return produtoModel;
    }

    @Override
    public List<ProdutoEntity> executeListarCategoria(String descricaoCategoria) {
        CategoriaModel categoriaModel = categoriaRepository.listarCategoriaByDescricao(descricaoCategoria);
        return produtoRepository.listaProdutoCategoria(categoriaModel.getId());
    }

    @Override
    public ProdutoModel executeAtualizar(ProdutoModel produtoModel) {
        produtoModel.setCategoriaModel(categoriaRepository.listarCategoriaById(produtoModel.getCategoriaModel().getId()));
        return produtoRepository.atualizaProduto(produtoModel);
    }

    @Override
    public void executeDeletar(Long id) {
        produtoRepository.deletaProduto(id);
    }
}
