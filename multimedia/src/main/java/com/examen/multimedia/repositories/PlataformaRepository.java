package com.examen.multimedia.repositories;

import com.examen.multimedia.models.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Integer> {
}
