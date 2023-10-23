package com.fiap.food_techchallenge.infra.config;

import com.fiap.food_techchallenge.domain.ports.inbound.CategoriaUseCasePort;
import com.fiap.food_techchallenge.domain.ports.inbound.ProdutoUseCasePort;
import com.fiap.food_techchallenge.domain.ports.inbound.UserUseCasePort;
import com.fiap.food_techchallenge.domain.ports.outbound.CategoriaAdapterPort;
import com.fiap.food_techchallenge.domain.ports.outbound.ProdutoAdapterPort;
import com.fiap.food_techchallenge.domain.ports.outbound.UserAdapterPort;
import com.fiap.food_techchallenge.domain.usecase.CategoriaUseCase;
import com.fiap.food_techchallenge.domain.usecase.ProdutoUseCase;
import com.fiap.food_techchallenge.domain.usecase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ProdutoUseCasePort produtoUseCase(ProdutoAdapterPort produtoAdapterPort, CategoriaAdapterPort categoriaAdapterPort){
        return new ProdutoUseCase(produtoAdapterPort, categoriaAdapterPort);
    }

    @Bean
    public CategoriaUseCasePort categoriaUseCase(CategoriaAdapterPort categoriaAdapterPort){
        return new CategoriaUseCase();
    }

    @Bean
    public UserUseCasePort userUseCasePort(UserAdapterPort userAdapterPort){
        return new UserUseCase();
    }

}
