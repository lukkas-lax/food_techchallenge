package com.fiap.food_techchallenge.domain.usecase;


import com.fiap.food_techchallenge.domain.domains.User;
import com.fiap.food_techchallenge.domain.ports.inbound.UserUseCasePort;
import com.fiap.food_techchallenge.domain.ports.outbound.UserAdapterPort;
import org.springframework.beans.factory.annotation.Autowired;

public class UserUseCase implements UserUseCasePort {

    @Autowired
    private UserAdapterPort userAdapterPort;


    @Override
    public User salvar(User user) {

        return userAdapterPort.salvar(user);
    }

    @Override
    public User listaUsuarios(Long id) {
        User user = userAdapterPort.listaUsuario(id);
        return user;
    }

    @Override
    public User listaUsuariosPorCpf(String cpf) {
        User user = userAdapterPort.listaUsuariosPorCpf(cpf);
        return user;
    }

    @Override
    public void deletaUser(Long id) {
        userAdapterPort.deletaUser(id);
    }


    }
