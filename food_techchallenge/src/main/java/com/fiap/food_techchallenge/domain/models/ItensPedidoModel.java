package com.fiap.food_techchallenge.domain.models;

import com.fiap.food_techchallenge.data.entities.ItensPedidoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItensPedidoModel {

    private Long id;
    private ProdutoModel produtoModel;
    private PedidoModel pedidoModel;

    public static ItensPedidoModel fromEntity(ItensPedidoEntity itensPedidoEntity) {
        return new ItensPedidoModel(itensPedidoEntity.getId(),
                ProdutoModel.fromEntity(itensPedidoEntity.getProdutoEntity()),
                PedidoModel.fromEntity(itensPedidoEntity.getPedidoEntity()));
    }

    public ItensPedidoModel(Long id, ProdutoModel produtoModel, PedidoModel pedidoModel) {
        this.id = id;
        this.produtoModel = produtoModel;
        this.pedidoModel = pedidoModel;
    }

    public ItensPedidoModel(ProdutoModel produtoModel, PedidoModel pedidoModel, Integer quantidade) {
        this.produtoModel = produtoModel;
        this.pedidoModel = pedidoModel;
    }
}
