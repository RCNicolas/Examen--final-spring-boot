package com.examen.multimedia.models;

import com.examen.multimedia.models.dtos.ContenidoMultimediaDTO;
import com.examen.multimedia.models.dtos.GeneroDTO;
import com.examen.multimedia.services.TipoService;
import jakarta.persistence.*;

@Entity
@Table(name = "contenido_multimedia")
public class ContenidoMultimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContenidoMultimedia;

    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo")
    private TipoContenido tipoContenido;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    public Integer getIdContenidoMultimedia() {
        return idContenidoMultimedia;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
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

    public TipoContenido getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(TipoContenido tipoContenido) {

        this.tipoContenido = tipoContenido;

    }

    public Genero getGeneroContenido() {
        return genero;
    }

    public void setGeneroContenido(Genero genero) {
        this.genero = genero;
    }

    public ContenidoMultimediaDTO toDTO(){
        ContenidoMultimediaDTO dto = new ContenidoMultimediaDTO();
        dto.setIdContenidoMultimedia(this.idContenidoMultimedia);
        dto.setNombre(this.nombre);
        dto.setIdGenero(this.genero.getIdGenero());
        dto.setIdTipo(this.tipoContenido.getIdTipo());
        return dto;
    }

    @Override
    public String toString() {
        return "ContenidoMultimedia{" +
                "idContenidoMultimedia=" + idContenidoMultimedia +
                ", nombre='" + nombre + '\'' +
                ", tipoContenido=" + tipoContenido +
                ", genero=" + genero +
                '}';
    }
}
