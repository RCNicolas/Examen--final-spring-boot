package com.examen.multimedia.services;

import com.examen.multimedia.exception.InvalidUserException;
import com.examen.multimedia.exception.UserDuplicateException;
import com.examen.multimedia.models.TipoContenido;
import com.examen.multimedia.models.Usuario;
import com.examen.multimedia.models.dtos.TipoDTO;
import com.examen.multimedia.models.dtos.UsuarioDTO;
import com.examen.multimedia.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {
   @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> obtenerUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(Usuario::toDTO)
                .toList();
    }

    public Usuario obtenerUsuarioById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void userValidation(String username, String password) {
        Usuario user = usuarioRepository.findByNombre(username);
        if (user == null || !user.getEncryptedPass().equalsIgnoreCase(password)) {
            throw new InvalidUserException("Las credenciales ingresadas son incorrectas");
        }
    }

    public Map<Object, Object> registerUser(Usuario user) {
        try {
            usuarioRepository.save(user);
            return new LinkedHashMap<>() {{
                put("message", "Usuario registrado exitosamente");
            }};
        } catch (Exception e) {
            throw new UserDuplicateException("El usuario ya existe");
        }
    }
}
