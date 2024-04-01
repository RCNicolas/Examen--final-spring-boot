package com.examen.multimedia.services;

import com.examen.multimedia.models.Usuario;
import com.examen.multimedia.models.contenidousuario.ContenidoUsuario;
import com.examen.multimedia.models.dtos.ContenidoUsuarioDTO;
import com.examen.multimedia.repositories.ContenidoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenidoUsuarioService {

    @Autowired
    ContenidoUsuarioRepository contenidoUsuarioRepository;
    public List<ContenidoUsuarioDTO> obtenerTodosContenidoUsuario() {
        return contenidoUsuarioRepository.findAll().stream()
                .map(ContenidoUsuario::toDTO)
                .toList();
    }

    public ContenidoUsuario guardarContenidoUsuario(ContenidoUsuario contenidoUsuario) {
        return contenidoUsuarioRepository.save(contenidoUsuario);
    }


}
