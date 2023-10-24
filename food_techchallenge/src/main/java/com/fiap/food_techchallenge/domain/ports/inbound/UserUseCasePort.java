package com.fiap.food_techchallenge.domain.ports.inbound;

import com.fiap.food_techchallenge.domain.User;

public interface UserUseCasePort {

    User salvar(User user);
    User listaUsuarios(Long id);
    User listaUsuariosPorCpf(String id);
    void deletaUser(Long id);
}
