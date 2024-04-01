package com.examen.multimedia.repositories;

import com.examen.multimedia.models.ContenidoMultimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenidoMultimediaRepository extends JpaRepository<ContenidoMultimedia, Integer> {
}
