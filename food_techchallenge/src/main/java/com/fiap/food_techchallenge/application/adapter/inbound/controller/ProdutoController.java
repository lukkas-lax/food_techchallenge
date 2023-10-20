package com.fiap.food_techchallenge.application.adapter.inbound.controller;

import com.fiap.food_techchallenge.application.adapter.inbound.request.ProdutoRequest;
import com.fiap.food_techchallenge.application.adapter.inbound.response.ProdutoResponse;
import com.fiap.food_techchallenge.domain.ports.inbound.ProdutoUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/food_techchallenge/produtos")
public class ProdutoController {

    private final ProdutoUseCasePort produtoUseCasePort;

    public ProdutoController(ProdutoUseCasePort produtoUseCasePort) {
        this.produtoUseCasePort = produtoUseCasePort;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criaProduto(@Valid @RequestBody ProdutoRequest produtoRequest){
        return ResponseEntity.ok(ProdutoResponse.fromDomain(produtoUseCasePort.executeSalvar(produtoRequest.toProdutoDomain())));
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<ProdutoResponse> atualizaProduto(@PathVariable Long produtoId, @Valid @RequestBody ProdutoRequest produtoRequest){
        return ResponseEntity.ok(ProdutoResponse.fromDomain(produtoUseCasePort.executeAtualizar(produtoRequest.toProdutoDomain(produtoId))));
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Void> deletaProduto(@PathVariable Long produtoId){
        produtoUseCasePort.executeDeletar(produtoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<ProdutoResponse> recuperaProdutoPorId(@PathVariable Long produtoId){
        return ResponseEntity.ok(ProdutoResponse.fromDomain(produtoUseCasePort.executeListar(produtoId)));
    }
}
