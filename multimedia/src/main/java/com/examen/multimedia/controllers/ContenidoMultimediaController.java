package com.examen.multimedia.controllers;

import com.examen.multimedia.models.ContenidoMultimedia;
import com.examen.multimedia.models.contenidousuario.ContenidoUsuario;
import com.examen.multimedia.models.dtos.ContenidoMultimediaDTO;
import com.examen.multimedia.models.dtos.ContenidoUsuarioDTO;
import com.examen.multimedia.services.ContenidoMultimediaService;
import com.examen.multimedia.services.ContenidoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contenido-multimedia")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
public class ContenidoMultimediaController {

    @Autowired
    ContenidoMultimediaService contenidoMultimediaService;
    @GetMapping
    public List<ContenidoMultimediaDTO> obtenerContenidoMultimedia() {
        return contenidoMultimediaService.obtenerContenidoMultimedia();
    }

    @PostMapping
    public ContenidoMultimedia guardarContenidoMultimedia(@RequestBody ContenidoMultimedia contenidoMultimedia) {
        return contenidoMultimediaService.guardarContenidoMultimedia(contenidoMultimedia);
    }

}
