package com.examen.multimedia.services;

import com.examen.multimedia.models.ContenidoMultimedia;
import com.examen.multimedia.models.Genero;
import com.examen.multimedia.models.dtos.ContenidoMultimediaDTO;
import com.examen.multimedia.repositories.ContenidoMultimediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenidoMultimediaService {

    @Autowired
    ContenidoMultimediaRepository contenidoMultimediaRepository;
    public List<ContenidoMultimediaDTO> obtenerContenidoMultimedia() {
        return contenidoMultimediaRepository.findAll().stream()
                .map(ContenidoMultimedia::toDTO)
                .toList();
    }

    public ContenidoMultimedia obtenerContenidoMultimediaById(Integer id) {
        return contenidoMultimediaRepository.findById(id).orElse(null);
    }

    public ContenidoMultimedia guardarContenidoMultimedia(ContenidoMultimedia contenidoMultimedia) {
        return contenidoMultimediaRepository.save(contenidoMultimedia);
    }

    public void deleteContenidoMultimedia(Integer id) {

        contenidoMultimediaRepository.deleteById(id);
    }

}
