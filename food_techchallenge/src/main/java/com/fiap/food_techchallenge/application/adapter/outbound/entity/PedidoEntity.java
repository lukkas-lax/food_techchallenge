package com.fiap.food_techchallenge.application.adapter.outbound.entity;

import com.fiap.food_techchallenge.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "pedidos")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @Column(name = "total")
    private Float total;

    @Temporal(TemporalType.DATE)
    @Column(name = "datapedido")
    private Date datapedido;

    @Enumerated
    @Column(name = "order_status")
    private OrderStatus orderStatus;

}
