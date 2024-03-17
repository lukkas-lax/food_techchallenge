package com.fiap.food_techchallenge.core.configurations;

import com.fiap.food_techchallenge.domain.ports.CategoriaUseCasePort;
import com.fiap.food_techchallenge.domain.ports.PedidoUseCasePort;
import com.fiap.food_techchallenge.domain.ports.ProdutoUseCasePort;
import com.fiap.food_techchallenge.domain.ports.UserUseCasePort;
import com.fiap.food_techchallenge.domain.repositories.CategoriaRepository;
import com.fiap.food_techchallenge.domain.repositories.PedidoRepository;
import com.fiap.food_techchallenge.domain.repositories.ProdutoRepository;
import com.fiap.food_techchallenge.domain.repositories.UserRepository;
import com.fiap.food_techchallenge.domain.usecases.CategoriaUseCase;
import com.fiap.food_techchallenge.domain.usecases.PedidoUseCase;
import com.fiap.food_techchallenge.domain.usecases.ProdutoUseCase;
import com.fiap.food_techchallenge.domain.usecases.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ProdutoUseCasePort produtoUseCase(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository){
        return new ProdutoUseCase(produtoRepository, categoriaRepository);
    }

    @Bean
    public CategoriaUseCasePort categoriaUseCase(CategoriaRepository categoriaRepository){
        return new CategoriaUseCase();
    }

    @Bean
    public UserUseCasePort userUseCasePort(UserRepository userRepository){
        return new UserUseCase();
    }

    @Bean
    public PedidoUseCasePort pedidoUseCasePort(PedidoRepository pedidoRepository, UserRepository userRepository, ProdutoRepository produtoRepository){
        return new PedidoUseCase(pedidoRepository, userRepository, produtoRepository);
    }
    //TODO

}
