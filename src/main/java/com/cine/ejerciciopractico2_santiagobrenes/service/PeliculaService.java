package com.cine.ejerciciopractico2_santiagobrenes.service;

import com.cine.ejerciciopractico2_santiagobrenes.domain.Pelicula;
import java.util.List;

public interface PeliculaService {
    List<Pelicula> getPeliculas();

    void savePelicula(Pelicula pelicula);

    Pelicula getPelicula(Pelicula pelicula);
}
