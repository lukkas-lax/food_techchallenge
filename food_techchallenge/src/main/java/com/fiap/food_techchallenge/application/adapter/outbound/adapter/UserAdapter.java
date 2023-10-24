package com.fiap.food_techchallenge.application.adapter.outbound.adapter;


import com.fiap.food_techchallenge.application.adapter.outbound.entity.UserEntity;
import com.fiap.food_techchallenge.application.adapter.outbound.repository.UserRepository;
import com.fiap.food_techchallenge.domain.domains.User;
import com.fiap.food_techchallenge.domain.ports.outbound.UserAdapterPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserAdapter implements UserAdapterPort {

    private final UserRepository userRepository;

    public UserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User salvar(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setNome(user.getNome());
        userEntity.setCpf(user.getCpf());
        userEntity.setEmail(user.getEmail());
        user.setId(userRepository.save(userEntity).getId());
        return user;
    }

    @Override
    public User listaUsuario(Long id) {
        try {
            var user = userRepository.findById(id);
            return User.fromEntity(user.get());
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public User listaUsuariosPorCpf(String cpf) {
        try {
            var user = userRepository.findByCpf(cpf);
            return User.fromEntity(user.get());
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void deletaUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }
}

