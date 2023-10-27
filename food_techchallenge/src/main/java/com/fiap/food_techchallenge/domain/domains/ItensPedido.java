package com.fiap.food_techchallenge.domain.domains;

import com.fiap.food_techchallenge.application.adapter.outbound.entity.ItensPedidoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItensPedido {

    private Long id;
    private Produto produto;
    private Pedido pedido;

    public static ItensPedido fromEntity(ItensPedidoEntity itensPedidoEntity) {
        return new ItensPedido(itensPedidoEntity.getId(),
                Produto.fromEntity(itensPedidoEntity.getProdutoEntity()),
                Pedido.fromEntity(itensPedidoEntity.getPedidoEntity()));
    }

    public ItensPedido(Long id, Produto produto, Pedido pedido) {
        this.id = id;
        this.produto = produto;
        this.pedido = pedido;
    }

    public ItensPedido(Produto produto, Pedido pedido, Integer quantidade) {
        this.produto = produto;
        this.pedido = pedido;
    }
}
