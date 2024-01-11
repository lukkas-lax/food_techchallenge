package com.fiap.food_techchallenge.domain.ports;

import com.fiap.food_techchallenge.domain.models.UserModel;

public interface UserUseCasePort {

    UserModel salvar(UserModel userModel);
    UserModel listaUsuarios(Long id);
    UserModel listaUsuariosPorCpf(String id);
    void deletaUser(Long id);
}
