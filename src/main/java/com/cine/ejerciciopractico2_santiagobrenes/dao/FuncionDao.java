package com.cine.ejerciciopractico2_santiagobrenes.dao;

import com.cine.ejerciciopractico2_santiagobrenes.domain.Funcion;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionDao extends JpaRepository<Funcion, Long> {
    List<Funcion> findFuncionsByPelicula(Pelicula pelicula);
}
