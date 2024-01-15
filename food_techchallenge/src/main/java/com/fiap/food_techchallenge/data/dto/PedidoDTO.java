package com.fiap.food_techchallenge.data.dto;

import com.fiap.food_techchallenge.domain.models.ProdutoModel;
import com.fiap.food_techchallenge.domain.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoDTO {

    private Long id;
    private UUID uuid;
    private UserModel userModel;
    private LocalDateTime datapedido;
    private Float total;
    private String orderStatus;
    private List<ProdutoModel> produtoModels;
}
