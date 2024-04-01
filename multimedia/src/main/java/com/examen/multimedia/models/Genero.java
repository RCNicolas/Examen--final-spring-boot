package com.examen.multimedia.models;

import com.examen.multimedia.models.dtos.GeneroDTO;
import com.examen.multimedia.models.dtos.PlataformaDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGenero;

    private String nombre;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    private List<ContenidoMultimedia> contenidoMultimedia;

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ContenidoMultimedia> getContenidoMultimedia() {
        return contenidoMultimedia;
    }

    public void setContenidoMultimedia(List<ContenidoMultimedia> contenidoMultimedia) {
        this.contenidoMultimedia = contenidoMultimedia;
    }


    public GeneroDTO toDTO(){
        GeneroDTO dto = new GeneroDTO();
        dto.setId(this.idGenero);
        dto.setNombre(this.nombre);
        return dto;
    }


    @Override
    public String toString() {
        return "Genero{" +
                "idGenero=" + idGenero +
                ", nombre='" + nombre + '\'' +
                ", contenidoMultimedia=" + contenidoMultimedia +
                '}';
    }
}
