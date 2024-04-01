package com.examen.multimedia.controllers;

import com.examen.multimedia.models.contenidousuario.ContenidoUsuario;
import com.examen.multimedia.models.dtos.ContenidoUsuarioDTO;
import com.examen.multimedia.models.dtos.GeneroDTO;
import com.examen.multimedia.services.ContenidoUsuarioService;
import com.examen.multimedia.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contenido-usuarios")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
public class ContenidoUsuarioController {

    @Autowired
    ContenidoUsuarioService contenidoUsuarioService;
    @GetMapping
    public List<ContenidoUsuarioDTO> obtenerTodosContenidoUsuario() {
        return contenidoUsuarioService.obtenerTodosContenidoUsuario();
    }
}
