package com.fiap.food_techchallenge.domain.ports.outbound;


import com.fiap.food_techchallenge.domain.domains.User;

public interface UserAdapterPort {

    User salvar(User user);
    User listaUsuario(Long id);
    User listaUsuariosPorCpf(String id);
    void deletaUser(Long id);
}
