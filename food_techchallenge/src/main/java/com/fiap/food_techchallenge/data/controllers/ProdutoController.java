package com.fiap.food_techchallenge.data.controllers;

import com.fiap.food_techchallenge.data.request.ProdutoRequest;
import com.fiap.food_techchallenge.data.response.ProdutoResponse;
import com.fiap.food_techchallenge.data.entities.ProdutoEntity;
import com.fiap.food_techchallenge.domain.ports.ProdutoUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("categoria/{descricaoCategoria}")
    public ResponseEntity<List<ProdutoEntity>> recuperaProdutoPorCategoria(@PathVariable String descricaoCategoria){
        return ResponseEntity.ok(produtoUseCasePort.executeListarCategoria(descricaoCategoria));
    }
}
