package com.examen.multimedia.services;

import com.examen.multimedia.models.Plataforma;
import com.examen.multimedia.models.TipoContenido;
import com.examen.multimedia.models.dtos.PlataformaDTO;
import com.examen.multimedia.repositories.PlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlataformaService {

    @Autowired
    PlataformaRepository plataformaRepository;
    public List<PlataformaDTO> obtenerTodasPlataformas() {
        return plataformaRepository.findAll().stream()
                .map(Plataforma::toDTO)
                .toList();
    }

    public Plataforma obtenerPlataformaById(Integer id) {
        return plataformaRepository.findById(id).orElse(null);
    }

    public Plataforma guardarPlataforma(Plataforma plataforma) {
        return plataformaRepository.save(plataforma);
    }

    public void deletePlataforma(Integer id) {

        plataformaRepository.deleteById(id);
    }
}
