package com.examen.multimedia.models;

import com.examen.multimedia.models.dtos.TipoDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tipo")
public class TipoContenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipo;

    private String nombre;

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDTO toDTO(){
        TipoDTO dto = new TipoDTO();
        dto.setId(this.idTipo);
        dto.setNombre(this.nombre);
        return dto;
    }

    @Override
    public String toString() {
        return "TipoContenido{" +
                "idTipo=" + idTipo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
