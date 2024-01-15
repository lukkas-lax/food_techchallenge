package com.fiap.food_techchallenge.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "pedidos")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @Column(name = "total")
    private Float total;

//    @Temporal(TemporalType.DATE)
    @Column(name = "datapedido")
    private LocalDateTime datapedido;

    @Column(name = "order_status")
    private String orderStatus;


}
