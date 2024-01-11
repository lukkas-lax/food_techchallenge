package com.fiap.food_techchallenge.data.controllers;

import com.fiap.food_techchallenge.data.request.PedidoRequest;
import com.fiap.food_techchallenge.data.response.PedidoResponse;
import com.fiap.food_techchallenge.data.dto.PedidoDTO;
import com.fiap.food_techchallenge.domain.ports.PedidoUseCasePort;
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

    @PutMapping("/{pedidoId}")
    public ResponseEntity<PedidoResponse> atualizaProduto(@PathVariable Long pedidoId){
        return ResponseEntity.ok(PedidoResponse.fromDomain(pedidoUseCasePort.executeAtualizar(pedidoId)));
    }
}

