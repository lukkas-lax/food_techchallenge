package com.fiap.food_techchallenge.domain.ports.outbound;


import com.fiap.food_techchallenge.domain.User;

public interface UserAdapterPort {

    User salvar(User user);
    User listaUsuarios(Long id);
    User listaUsuariosPorCpf(User id);
    void deletaUser(Long id);
}
