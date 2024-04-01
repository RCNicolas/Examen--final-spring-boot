package com.examen.multimedia.repositories;

import com.examen.multimedia.models.contenidousuario.ContenidoUsuario;
import com.examen.multimedia.models.contenidousuario.ContenidoUsuarioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenidoUsuarioRepository extends JpaRepository<ContenidoUsuario, ContenidoUsuarioId> {
}
