package com.examen.multimedia.controllers;

import com.examen.multimedia.models.Plataforma;
import com.examen.multimedia.models.TipoContenido;
import com.examen.multimedia.models.dtos.PlataformaDTO;
import com.examen.multimedia.models.dtos.TipoDTO;
import com.examen.multimedia.services.PlataformaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plataformas")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
public class PlataformaController {

    @Autowired
    PlataformaService plataformaService;
    @GetMapping
    public List<PlataformaDTO> obtenerTodasPlataformas() {
        return plataformaService.obtenerTodasPlataformas();
    }

    @PostMapping
    public Plataforma guardarPlataforma(@RequestBody Plataforma plataforma) {
        return plataformaService.guardarPlataforma(plataforma);
    }
}
