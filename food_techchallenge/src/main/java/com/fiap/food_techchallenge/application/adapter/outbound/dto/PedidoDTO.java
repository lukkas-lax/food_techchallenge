package com.fiap.food_techchallenge.application.adapter.outbound.dto;

import com.fiap.food_techchallenge.domain.domains.Produto;
import com.fiap.food_techchallenge.domain.domains.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoDTO {

    private Long id;
    private User user;
    private LocalDateTime datapedido;
    private Float total;
    private String orderStatus;
    private List<Produto> produtos;
    private String paymentStatus;
}
