package com.fiap.food_techchallenge.data.dto;

import com.fiap.food_techchallenge.domain.models.ProdutoModel;
import com.fiap.food_techchallenge.domain.models.UserModel;
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
    private UserModel userModel;
    private LocalDateTime datapedido;
    private Float total;
    private String orderStatus;
    private List<ProdutoModel> produtoModels;
}
