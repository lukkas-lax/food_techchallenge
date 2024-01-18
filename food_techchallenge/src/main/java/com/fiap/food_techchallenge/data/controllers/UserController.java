package com.fiap.food_techchallenge.data.controllers;

import com.fiap.food_techchallenge.data.request.UserRequest;
import com.fiap.food_techchallenge.data.response.UserResponse;
import com.fiap.food_techchallenge.domain.models.UserModel;
import com.fiap.food_techchallenge.domain.ports.UserUseCasePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Usuário", description = "API para gerenciamento de usuários na plataforma")
@RestController
@RequestMapping("api/food_techchallenge/users")
public class UserController {

    private final UserUseCasePort userUseCasePort;

    public UserController(UserUseCasePort userUseCasePort) {
        this.userUseCasePort = userUseCasePort;
    }

    @Operation(
            summary = "Cria Usuário",
            description = "Adiciona um usuário ao sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping
    public ResponseEntity<UserResponse> criaUsuario(@RequestBody UserRequest userRequest){
        UserModel userModel = userRequest.toUserDomain();
        UserResponse userResponse = UserResponse.fromDomain(userUseCasePort.salvar(userModel));
        return ResponseEntity.ok(userResponse);
    }

    @Operation(
            summary = "Procura Usuário",
            description = "Lista um usuário com base no seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUsuario(@PathVariable Long userId){
        return ResponseEntity.ok(UserResponse.fromDomain(userUseCasePort.listaUsuarios(userId)));
    }


    @Operation(
            summary = "Procura Usuário (CPF)",
            description = "Lista um usuário com base no seu cpf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("cpf/{cpf}")
    public ResponseEntity<UserResponse> getUsuarioPorCpf(@PathVariable String cpf){
        return ResponseEntity.ok(UserResponse.fromDomain(userUseCasePort.listaUsuariosPorCpf(cpf)));
    }

    @Operation(
            summary = "Deleta Usuário",
            description = "Deleta um usuário do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deletaUsuario(@PathVariable Long userId){
        userUseCasePort.deletaUser(userId);
        return ResponseEntity.ok("Usuário " + userId +" deletado com sucesso.");
    }
}
