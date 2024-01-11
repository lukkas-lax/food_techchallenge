package com.fiap.food_techchallenge.domain.repositories;


import com.fiap.food_techchallenge.domain.models.UserModel;

public interface UserRepository {

    UserModel salvar(UserModel userModel);
    UserModel listaUsuario(Long id);
    UserModel listaUsuariosPorCpf(String id);
    void deletaUser(Long id);
}
