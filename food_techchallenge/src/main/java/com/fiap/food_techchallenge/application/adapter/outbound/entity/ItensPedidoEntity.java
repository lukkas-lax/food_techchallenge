package com.fiap.food_techchallenge.application.adapter.outbound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "itenspedido")
public class ItensPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produtoEntity;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedidoEntity;

    @Column(name = "quantidade")
    private Integer quantidade;

}
