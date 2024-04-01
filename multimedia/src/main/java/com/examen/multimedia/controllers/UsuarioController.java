package com.examen.multimedia.controllers;

import com.examen.multimedia.models.Usuario;
import com.examen.multimedia.models.dtos.UsuarioDTO;
import com.examen.multimedia.security.JWTAuthenticationConfig;
import com.examen.multimedia.services.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class UsuarioController {

    @Autowired
    JWTAuthenticationConfig jwtAuthenticationConfig;

    @Autowired
    UsuarioService usuarioService;
    @GetMapping("/usuarios")
    public List<UsuarioDTO> obtenerTodosLosTipos(){
        return usuarioService.obtenerUsuarios();
    }
    @PostMapping("/login")
    public Usuario login(
            @RequestParam("user") String nombre,
            @RequestParam("encryptedPass") String encryptedPass) {

        usuarioService.userValidation(nombre, encryptedPass);
        String token = jwtAuthenticationConfig.getJWTToken(nombre);
        return new Usuario(nombre, encryptedPass, token);
    }

    @PostMapping("/register")
    public Map<Object, Object> registerUser(
            @RequestParam("user") String nombre,
            @RequestParam("encryptedPass") String encryptedPass) {

        return usuarioService.registerUser(new Usuario(nombre, encryptedPass, null));
    }

}
