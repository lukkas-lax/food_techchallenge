package com.fiap.food_techchallenge.domain.usecases;

import com.fiap.food_techchallenge.domain.models.CategoriaModel;
import com.fiap.food_techchallenge.domain.ports.CategoriaUseCasePort;
import com.fiap.food_techchallenge.domain.repositories.CategoriaRepository;

public class CategoriaUseCase implements CategoriaUseCasePort {

    private CategoriaRepository categoriaRepository;
    @Override
    public CategoriaModel execute(Long id) {
        return categoriaRepository.listarCategoriaById(id);
    }

    @Override
    public CategoriaModel execute(String descricao) {
        return categoriaRepository.listarCategoriaByDescricao(descricao);
    }
}
