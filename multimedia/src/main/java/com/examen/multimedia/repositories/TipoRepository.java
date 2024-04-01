package com.examen.multimedia.repositories;

import com.examen.multimedia.models.TipoContenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<TipoContenido, Integer> {
}
