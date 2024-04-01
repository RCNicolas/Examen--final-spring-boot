package com.examen.multimedia.models.contenidousuario;

import com.examen.multimedia.models.ContenidoMultimedia;
import com.examen.multimedia.models.Plataforma;
import com.examen.multimedia.models.Usuario;
import com.examen.multimedia.models.dtos.ContenidoMultimediaDTO;
import com.examen.multimedia.models.dtos.ContenidoUsuarioDTO;
import jakarta.persistence.*;

@Entity
@Table (name = "contenido_usuario")
public class ContenidoUsuario {

    @EmbeddedId
    private ContenidoUsuarioId idContenidoUsuarioId;

    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @MapsId("idContenido")
    @JoinColumn(name = "id_contenido")
    private ContenidoMultimedia contenidoMultimedia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_plataforma")
    private Plataforma plataforma;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "calificacion", nullable = false)
    private double calificacion;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    public ContenidoUsuarioId getIdContenidoUsuarioId() {
        return idContenidoUsuarioId;
    }

    public void setIdContenidoUsuarioId(ContenidoUsuarioId idContenidoUsuarioId) {
        this.idContenidoUsuarioId = idContenidoUsuarioId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ContenidoMultimedia getContenidoMultimedia() {
        return contenidoMultimedia;
    }

    public void setContenidoMultimedia(ContenidoMultimedia contenidoMultimedia) {
        this.contenidoMultimedia = contenidoMultimedia;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        ContenidoUsuario contenidoUsuario = new ContenidoUsuario();
        if (contenidoUsuario.getEstado().equals("Terminado") || contenidoUsuario.getEstado().equals("Abandonado") ){

            this.calificacion = calificacion;

        }else {
            System.out.println("La calificacion no puede ser agregada si no existe un estado 'Terminado' o 'Abandonado'");
        }

    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {

        ContenidoUsuario contenidoUsuario = new ContenidoUsuario();
        if (contenidoUsuario.getEstado().equals("Terminado") || contenidoUsuario.getEstado().equals("Abandonado") ){

            this.comentario = comentario;

        }else {
            System.out.println("El comentario no puede ser agregada si no existe un estado 'Terminado' o 'Abandonado'");
        }

    }

    public ContenidoUsuarioDTO toDTO(){
        ContenidoUsuarioDTO dto = new ContenidoUsuarioDTO();
        dto.setIdUsuario(this.usuario.getIdUsuario());
        dto.setIdContenido(this.contenidoMultimedia.getIdContenidoMultimedia());
        dto.setIdPlataforma(this.plataforma.getIdPlataforma());
        dto.setEstado(this.estado);
        dto.setCalificacion(this.calificacion);
        dto.setComentario(this.comentario);
        return dto;
    }

    @Override
    public String toString() {
        return "ContenidoUsuario{" +
                "idContenidoUsuarioId=" + idContenidoUsuarioId +
                ", usuario=" + usuario +
                ", contenidoMultimedia=" + contenidoMultimedia +
                ", plataforma=" + plataforma +
                ", estado='" + estado + '\'' +
                ", calificacion=" + calificacion +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
