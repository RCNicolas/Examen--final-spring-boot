package com.examen.multimedia.controllers;

import com.examen.multimedia.models.TipoContenido;
import com.examen.multimedia.models.dtos.TipoDTO;
import com.examen.multimedia.repositories.TipoRepository;
import com.examen.multimedia.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
//@SecurityRequirement(name = "bearerAuth")
public class TipoController {

    @Autowired
    TipoService tipoService;

    @GetMapping
    public List<TipoDTO> obtenerTodosLosTipos(){
        return tipoService.obtenerTodosTipos();
    }

    @GetMapping("/tipo-by-id/{id}")
    public TipoContenido obtenerTipoContenidoById(@PathVariable Integer id){
        return tipoService.obtenerTipoContenidoById(id);
    }

    @PostMapping
    public TipoContenido guardarTipoContenido(@RequestBody TipoContenido tipoContenido) {
        return tipoService.guardarTipoContenido(tipoContenido);
    }

}
