package com.fiap.food_techchallenge.data.adapter;


import com.fiap.food_techchallenge.data.entities.UserEntity;
import com.fiap.food_techchallenge.data.repositories.UserJpaRepository;
import com.fiap.food_techchallenge.domain.models.UserModel;
import com.fiap.food_techchallenge.domain.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    @Transactional
    public UserModel salvar(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setNome(userModel.getNome());
        userEntity.setCpf(userModel.getCpf());
        userEntity.setEmail(userModel.getEmail());
        userModel.setId(userJpaRepository.save(userEntity).getId());
        return userModel;
    }

    @Override
    public UserModel listaUsuario(Long id) {
        try {
            var user = userJpaRepository.findById(id);
            return UserModel.fromEntity(user.get());
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public UserModel listaUsuariosPorCpf(String cpf) {
        try {
            var user = userJpaRepository.findByCpf(cpf);
            return UserModel.fromEntity(user.get());
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void deletaUser(Long id) {
        try {
            userJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }
}

