package com.cine.ejerciciopractico2_santiagobrenes.service;

import com.cine.ejerciciopractico2_santiagobrenes.domain.Reserva;
import java.util.List;

public interface ReservaService {
    List<Reserva> getReservas();

    void save(Reserva reserva);
}
