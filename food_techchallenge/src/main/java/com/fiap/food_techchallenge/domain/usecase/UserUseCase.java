package com.fiap.food_techchallenge.domain.usecase;

import com.fiap.food_techchallenge.domain.Categoria;
import com.fiap.food_techchallenge.domain.Produto;
import com.fiap.food_techchallenge.domain.User;
import com.fiap.food_techchallenge.domain.ports.inbound.CategoriaUseCasePort;
import com.fiap.food_techchallenge.domain.ports.inbound.UserUseCasePort;
import com.fiap.food_techchallenge.domain.ports.outbound.CategoriaAdapterPort;
import com.fiap.food_techchallenge.domain.ports.outbound.UserAdapterPort;
import jakarta.persistence.EntityNotFoundException;
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
        User user = userAdapterPort.listaUsuarios(id);
        return user;
    }

    @Override
    public User listaUsuariosPorCpf(User id) {
        return null;
    }

    @Override
    public void deletaUser(Long id) {

    }


    }
