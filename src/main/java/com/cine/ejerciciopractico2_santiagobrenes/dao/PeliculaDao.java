package com.cine.ejerciciopractico2_santiagobrenes.dao;

import com.cine.ejerciciopractico2_santiagobrenes.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaDao extends JpaRepository<Pelicula, Long> {
}
