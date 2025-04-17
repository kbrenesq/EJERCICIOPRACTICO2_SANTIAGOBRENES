package com.cine.ejerciciopractico2_santiagobrenes.dao;

import com.cine.ejerciciopractico2_santiagobrenes.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaDao extends JpaRepository<Reserva, Long> {
}
