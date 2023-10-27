package com.fiap.food_techchallenge.application.adapter.outbound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Entity
@Getter
@Setter
@Table(name = "itenspedido")
@NoArgsConstructor
public class ItensPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produtoEntity;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedidoEntity;

    public ItensPedidoEntity(ProdutoEntity produtoRetorno, PedidoEntity pedidoRetorno) {
        this.produtoEntity = produtoRetorno;
        this.pedidoEntity = pedidoRetorno;
    }
}
