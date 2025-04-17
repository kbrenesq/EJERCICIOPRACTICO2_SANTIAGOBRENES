package com.cine.ejerciciopractico2_santiagobrenes.dao;

import com.cine.ejerciciopractico2_santiagobrenes.domain.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionDao extends JpaRepository<Funcion, Long> {
}
