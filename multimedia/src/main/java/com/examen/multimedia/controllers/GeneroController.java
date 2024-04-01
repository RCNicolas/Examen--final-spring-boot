package com.examen.multimedia.controllers;

import com.examen.multimedia.models.Genero;
import com.examen.multimedia.models.Plataforma;
import com.examen.multimedia.models.dtos.GeneroDTO;
import com.examen.multimedia.models.dtos.PlataformaDTO;
import com.examen.multimedia.services.GeneroService;
import com.examen.multimedia.services.PlataformaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
public class GeneroController {

    @Autowired
    GeneroService generoService;
    @GetMapping
    public List<GeneroDTO> obtenerTodosGeneros() {
        return generoService.obtenerTodosGeneros();
    }

    @PostMapping
    public Genero guardarGenero(@RequestBody Genero genero) {
        return generoService.guardarGenero(genero);
    }
}
