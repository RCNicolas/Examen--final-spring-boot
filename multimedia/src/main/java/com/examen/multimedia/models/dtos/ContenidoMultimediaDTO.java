package com.examen.multimedia.models.dtos;

import org.hibernate.boot.archive.scan.internal.ScanResultImpl;

public class ContenidoMultimediaDTO {

    private Integer idContenidoMultimedia;
    private String nombre;

    private Integer idGenero;
    private Integer idTipo;

    public ContenidoMultimediaDTO() {
    }

    public Integer getIdContenidoMultimedia() {
        return idContenidoMultimedia;
    }

    public void setIdContenidoMultimedia(Integer idContenidoMultimedia) {
        this.idContenidoMultimedia = idContenidoMultimedia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }
}
