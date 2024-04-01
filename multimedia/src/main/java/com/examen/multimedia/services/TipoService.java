package com.examen.multimedia.services;

import com.examen.multimedia.models.TipoContenido;
import com.examen.multimedia.models.dtos.TipoDTO;
import com.examen.multimedia.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService {

    @Autowired
    TipoRepository tipoRepository;

    public List<TipoDTO> obtenerTodosTipos() {
        return tipoRepository.findAll().stream()
                .map(TipoContenido::toDTO)
                .toList();
    }

    public TipoContenido obtenerTipoContenidoById(Integer id) {
        return tipoRepository.findById(id).orElse(null);
    }

    public TipoContenido guardarTipoContenido(TipoContenido tipoContenido) {
        return tipoRepository.save(tipoContenido);
    }

    public void deleteTipoContenido(Integer id) {

        tipoRepository.deleteById(id);
    }

    public void actualizarTipo(Integer id, TipoContenido tipoContenido){
        TipoContenido tipoContenido1 = tipoRepository.findById(id).orElse(null);

        tipoContenido1.setNombre(tipoContenido.getNombre());

        tipoRepository.save(tipoContenido1);
    }

}
