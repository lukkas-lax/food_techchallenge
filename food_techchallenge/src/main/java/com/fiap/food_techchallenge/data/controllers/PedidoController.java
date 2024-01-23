package com.fiap.food_techchallenge.data.controllers;

import com.fiap.food_techchallenge.data.request.PedidoRequest;
import com.fiap.food_techchallenge.data.response.PedidoResponse;
import com.fiap.food_techchallenge.data.dto.PedidoDTO;
import com.fiap.food_techchallenge.domain.ports.PedidoUseCasePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pedido", description = "API para criação e listagem de pedidos")
@RestController
@RequestMapping("api/food_techchallenge/pedidos")
public class PedidoController {

    private final PedidoUseCasePort pedidoUseCasePort;

    public PedidoController(PedidoUseCasePort pedidoUseCasePort) {
        this.pedidoUseCasePort = pedidoUseCasePort;
    }

    @Operation(
            summary = "Cria Pedido",
            description = "Adiciona um pedido ao sistema com os produtos selecionados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping
    public ResponseEntity<PedidoResponse> criaPedido(@Valid @RequestBody PedidoRequest pedidoRequest){
        return ResponseEntity.ok(PedidoResponse.fromDomain(pedidoUseCasePort.executeSalvar(pedidoRequest.toPedidoDomain(), pedidoRequest.getProdutosIds())));
    }

//    @GetMapping("/{produtoId}")
//    public ResponseEntity<ProdutoResponse> recuperaProdutoPorId(@PathVariable Long produtoId){
//        return ResponseEntity.ok(ProdutoResponse.fromDomain(produtoUseCasePort.executeListar(produtoId)));
//    }
//

    @Operation(
            summary = "Lista Pedido (Por STATUS)",
            description = "Lista todos os pedidos com o status selecionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("status/{status}")
    public ResponseEntity<List<PedidoDTO>> recuperaPedidoporStatus(@PathVariable String status){
        return ResponseEntity.ok(pedidoUseCasePort.executeListarStatus(status));
    }

    @Operation(
            summary = "Lista Pedido (ATIVOS)",
            description = "Lista todos os pedidos com o status ativos, ordenados por data de criação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping()
    public ResponseEntity<List<PedidoDTO>> recuperaPedidos(){
        return ResponseEntity.ok(pedidoUseCasePort.executeListarTodos());
    }

    @Operation(
            summary = "Atualiza Status Pedidos",
            description = "Altera o status do pedido para o status seguinte.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PutMapping("/{pedidoId}")
    public ResponseEntity<PedidoResponse> atualizaProduto(@PathVariable Long pedidoId){
        return ResponseEntity.ok(PedidoResponse.fromDomain(pedidoUseCasePort.executeAtualizar(pedidoId)));
    }

    @GetMapping("/payment-status/{pedidoId}")
    public ResponseEntity<PedidoDTO> consultaStatusPagamnento(@PathVariable Long pedidoId) {
        return ResponseEntity.ok(pedidoUseCasePort.buscaStatusPagamento(pedidoId));
    }
}

