package com.examen.multimedia.controllers;

import com.examen.multimedia.models.dtos.PlataformaDTO;
import com.examen.multimedia.models.dtos.TipoDTO;
import com.examen.multimedia.services.PlataformaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pltaformas")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
public class PlataformaController {

    @Autowired
    PlataformaService plataformaService;
    @GetMapping
    public List<PlataformaDTO> obtenerTodasPlataformas() {
        return plataformaService.obtenerTodasPlataformas();
    }
}
