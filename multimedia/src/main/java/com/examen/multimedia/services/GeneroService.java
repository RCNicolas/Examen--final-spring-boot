package com.examen.multimedia.services;

import com.examen.multimedia.models.Genero;
import com.examen.multimedia.models.Plataforma;
import com.examen.multimedia.models.dtos.GeneroDTO;
import com.examen.multimedia.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    GeneroRepository generoRepository;
    public List<GeneroDTO> obtenerTodosGeneros() {
        return generoRepository.findAll().stream()
                .map(Genero::toDTO)
                .toList();
    }

    public Genero obtenerGeneroById(Integer id) {
        return generoRepository.findById(id).orElse(null);
    }

    public Genero guardarGenero(Genero genero) {
        return generoRepository.save(genero);
    }

    public void deleteGenero(Integer id) {

        generoRepository.deleteById(id);
    }
}
