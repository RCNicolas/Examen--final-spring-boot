package com.examen.multimedia.models;

import com.examen.multimedia.models.contenidousuario.ContenidoUsuarioId;
import com.examen.multimedia.models.dtos.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer idUsuario;

    @JsonIgnore
    @Column(unique = true, nullable = false)
    private String nombre;

    @JsonIgnore
    @Column(name = "contraseña", nullable = false)
    private String encryptedPass;

    @Transient
    private String token;

    public Usuario() {
    }

    public Usuario(String nombre, String encryptedPass, String token) {
        this.nombre = nombre;
        this.encryptedPass = encryptedPass;
        this.token = token;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEncryptedPass() {
        return encryptedPass;
    }

    public void setEncryptedPass(String encryptedPass) {
        this.encryptedPass = encryptedPass;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UsuarioDTO toDTO(){
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(this.idUsuario);
        dto.setNombre(this.nombre);
        return dto;
    }
}
