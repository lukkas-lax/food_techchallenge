package com.fiap.food_techchallenge.application.adapter.inbound.controller;

import com.fiap.food_techchallenge.application.adapter.inbound.request.PedidoRequest;
import com.fiap.food_techchallenge.application.adapter.inbound.response.PedidoResponse;
import com.fiap.food_techchallenge.application.adapter.outbound.dto.PedidoDTO;
import com.fiap.food_techchallenge.application.adapter.outbound.entity.PedidoEntity;
import com.fiap.food_techchallenge.domain.ports.inbound.PedidoUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/food_techchallenge/pedidos")
public class PedidoController {

    private final PedidoUseCasePort pedidoUseCasePort;

    public PedidoController(PedidoUseCasePort pedidoUseCasePort) {
        this.pedidoUseCasePort = pedidoUseCasePort;
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> criaPedido(@Valid @RequestBody PedidoRequest pedidoRequest){
        return ResponseEntity.ok(PedidoResponse.fromDomain(pedidoUseCasePort.executeSalvar(pedidoRequest.toPedidoDomain(), pedidoRequest.getProdutosIds())));
    }

//    @GetMapping("/{produtoId}")
//    public ResponseEntity<ProdutoResponse> recuperaProdutoPorId(@PathVariable Long produtoId){
//        return ResponseEntity.ok(ProdutoResponse.fromDomain(produtoUseCasePort.executeListar(produtoId)));
//    }
//
    @GetMapping("status/{status}")
    public ResponseEntity<List<PedidoDTO>> recuperaPedidoporStatus(@PathVariable String status){
        return ResponseEntity.ok(pedidoUseCasePort.executeListarStatus(status));
    }
}

