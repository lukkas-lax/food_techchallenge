package com.fiap.food_techchallenge.application.adapter.outbound.adapter;


import com.fiap.food_techchallenge.application.adapter.outbound.entity.ProdutoEntity;
import com.fiap.food_techchallenge.application.adapter.outbound.repository.ProdutoRepository;
import com.fiap.food_techchallenge.domain.Produto;
import com.fiap.food_techchallenge.domain.ports.outbound.ProdutoAdapterPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProdutoAdapter implements ProdutoAdapterPort {

    private final ProdutoRepository produtoRepository;

    public ProdutoAdapter(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional
    public Produto salvar(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setPreco(produto.getPreco());
        produtoEntity.setCategoriaId(produto.getCategoria().getId());
        produto.setId(produtoRepository.save(produtoEntity).getId());
        return produto;
    }

    @Override
    public Produto listaProduto(Long id) {
        try{
            var produto = produtoRepository.findById(id);
            return Produto.fromEntity(produto.get());
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }

    }

    @Override
    @Transactional
    public Produto atualizaProduto(Produto produto) {
        ProdutoEntity produtoEntity = produtoRepository.findById(produto.getId()).get();
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setPreco(produto.getPreco());
        produtoEntity.setCategoriaId(produto.getCategoria().getId());
        produtoRepository.save(produtoEntity);
        return produto;
    }

    @Override
    @Transactional
    public void deletaProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
