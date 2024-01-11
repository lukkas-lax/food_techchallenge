package com.fiap.food_techchallenge.data.adapter;


import com.fiap.food_techchallenge.data.entities.CategoriaEntity;
import com.fiap.food_techchallenge.data.repositories.CategoriaJpaRepository;
import com.fiap.food_techchallenge.domain.models.CategoriaModel;
import com.fiap.food_techchallenge.domain.repositories.CategoriaRepository;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Component;

@Component
public class CategoriaAdapter implements CategoriaRepository {

    private final CategoriaJpaRepository categoriaJpaRepository;

    public CategoriaAdapter(CategoriaJpaRepository categoriaJpaRepository) {
        this.categoriaJpaRepository = categoriaJpaRepository;
    }

    @Override
    public CategoriaModel listarCategoriaById(Long id) {
        try {
            var categoriaEntity = categoriaJpaRepository.findById(id);
            return CategoriaModel.fromEntity(categoriaEntity.get());
        } catch(Exception exception) {
            throw new NoResultException();
        }
    }

    @Override
    public CategoriaModel listarCategoriaByDescricao(String descricao) {
        try {
            var categoriaEntity = categoriaJpaRepository.findByDescricao(descricao);
            return CategoriaModel.fromEntity((CategoriaEntity) categoriaEntity);
        } catch(Exception exception) {
            throw new NoResultException();
        }
    }

}
