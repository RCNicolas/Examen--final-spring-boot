package com.examen.multimedia.models;

import com.examen.multimedia.models.dtos.PlataformaDTO;
import com.examen.multimedia.models.dtos.TipoDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "plataforma")
public class Plataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlataforma;

    private String nombre;

    public Integer getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Integer idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public PlataformaDTO toDTO(){
        PlataformaDTO dto = new PlataformaDTO();
        dto.setId(this.idPlataforma);
        dto.setNombre(this.nombre);
        return dto;
    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "idPlataforma=" + idPlataforma +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
