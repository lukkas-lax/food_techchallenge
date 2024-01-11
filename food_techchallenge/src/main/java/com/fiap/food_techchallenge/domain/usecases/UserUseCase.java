package com.fiap.food_techchallenge.domain.usecases;


import com.fiap.food_techchallenge.domain.models.UserModel;
import com.fiap.food_techchallenge.domain.ports.UserUseCasePort;
import com.fiap.food_techchallenge.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserUseCase implements UserUseCasePort {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserModel salvar(UserModel userModel) {

        return userRepository.salvar(userModel);
    }

    @Override
    public UserModel listaUsuarios(Long id) {
        UserModel userModel = userRepository.listaUsuario(id);
        return userModel;
    }

    @Override
    public UserModel listaUsuariosPorCpf(String cpf) {
        UserModel userModel = userRepository.listaUsuariosPorCpf(cpf);
        return userModel;
    }

    @Override
    public void deletaUser(Long id) {
        userRepository.deletaUser(id);
    }


    }
