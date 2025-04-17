package com.cine.ejerciciopractico2_santiagobrenes.service;

import com.cine.ejerciciopractico2_santiagobrenes.domain.Funcion;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Pelicula;

import java.util.List;

public interface FuncionService {
    List<Funcion> getFunciones();

    public void save(Funcion funcion);

    public Funcion getFuncion(Funcion funcion);

    public List<Funcion> getFuncionesByPelicula(Pelicula pelicula);
}
