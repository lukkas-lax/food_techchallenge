package com.fiap.food_techchallenge.data.controllers;

import com.fiap.food_techchallenge.data.request.UserRequest;
import com.fiap.food_techchallenge.data.response.UserResponse;
import com.fiap.food_techchallenge.domain.models.UserModel;
import com.fiap.food_techchallenge.domain.ports.UserUseCasePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/food_techchallenge/users")
public class UserController {

    private final UserUseCasePort userUseCasePort;

    public UserController(UserUseCasePort userUseCasePort) {
        this.userUseCasePort = userUseCasePort;
    }

    @PostMapping
    public ResponseEntity<UserResponse> criaUsuario(@RequestBody UserRequest userRequest){
        UserModel userModel = userRequest.toUserDomain();
        UserResponse userResponse = UserResponse.fromDomain(userUseCasePort.salvar(userModel));
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUsuario(@PathVariable Long userId){
        return ResponseEntity.ok(UserResponse.fromDomain(userUseCasePort.listaUsuarios(userId)));
    }


    @GetMapping("cpf/{cpf}")
    public ResponseEntity<UserResponse> getUsuarioPorCpf(@PathVariable String cpf){
        return ResponseEntity.ok(UserResponse.fromDomain(userUseCasePort.listaUsuariosPorCpf(cpf)));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deletaUsuario(@PathVariable Long userId){
        userUseCasePort.deletaUser(userId);
        return ResponseEntity.ok("Usuário " + userId +" deletado com sucesso.");
    }
}
