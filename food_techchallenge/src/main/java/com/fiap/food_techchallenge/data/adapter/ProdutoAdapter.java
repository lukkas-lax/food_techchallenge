package com.fiap.food_techchallenge.data.adapter;


import com.fiap.food_techchallenge.data.entities.ProdutoEntity;
import com.fiap.food_techchallenge.data.repositories.ProdutoJpaRepository;
import com.fiap.food_techchallenge.domain.models.ProdutoModel;
import com.fiap.food_techchallenge.domain.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProdutoAdapter implements ProdutoRepository {

    private final ProdutoJpaRepository produtoJpaRepository;

    public ProdutoAdapter(ProdutoJpaRepository produtoJpaRepository) {
        this.produtoJpaRepository = produtoJpaRepository;
    }

    @Override
    @Transactional
    public ProdutoModel salvar(ProdutoModel produtoModel) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(produtoModel.getNome());
        produtoEntity.setDescricao(produtoModel.getDescricao());
        produtoEntity.setPreco(produtoModel.getPreco());
        produtoEntity.setCategoriaId(produtoModel.getCategoriaModel().getId());
        produtoModel.setId(produtoJpaRepository.save(produtoEntity).getId());
        return produtoModel;
    }

    @Override
    public ProdutoModel listaProduto(Long id) {
        try{
            var produto = produtoJpaRepository.findById(id);
            return ProdutoModel.fromEntity(produto.get());
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }

    }

    @Override
    public List<ProdutoEntity> listaProdutoCategoria(Long id) {
        try{
            return produtoJpaRepository.findAllByCategoriaId(id);
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    @Transactional
    public ProdutoModel atualizaProduto(ProdutoModel produtoModel) {
        ProdutoEntity produtoEntity = produtoJpaRepository.findById(produtoModel.getId()).get();
        produtoEntity.setNome(produtoModel.getNome());
        produtoEntity.setDescricao(produtoModel.getDescricao());
        produtoEntity.setPreco(produtoModel.getPreco());
        produtoEntity.setCategoriaId(produtoModel.getCategoriaModel().getId());
        produtoJpaRepository.save(produtoEntity);
        return produtoModel;
    }

    @Override
    @Transactional
    public void deletaProduto(Long id) {
        produtoJpaRepository.deleteById(id);
    }
}
