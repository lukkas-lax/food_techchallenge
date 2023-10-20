package com.fiap.food_techchallenge.application.adapter.outbound.adapter;


import com.fiap.food_techchallenge.application.adapter.outbound.repository.CategoriaRepository;
import com.fiap.food_techchallenge.domain.Categoria;
import com.fiap.food_techchallenge.domain.ports.outbound.CategoriaAdapterPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CategoriaAdapter implements CategoriaAdapterPort {

    private final CategoriaRepository categoriaRepository;

    public CategoriaAdapter(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria listarCategoriaById(Long id) {
        try {
            var categoriaEntity = categoriaRepository.findById(id);
            return Categoria.fromEntity(categoriaEntity.get());
        } catch(Exception exception) {
            throw new EntityNotFoundException();
        }
    }

}
