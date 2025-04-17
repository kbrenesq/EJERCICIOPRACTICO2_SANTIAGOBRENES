package com.cine.ejerciciopractico2_santiagobrenes.service.impl;

import com.cine.ejerciciopractico2_santiagobrenes.dao.PeliculaDao;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Pelicula;
import com.cine.ejerciciopractico2_santiagobrenes.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaDao peliculaDao;

    @Override
    public List<Pelicula> getPeliculas() {
        return peliculaDao.findAll();
    }

    @Override
    public void savePelicula(Pelicula pelicula) {
        peliculaDao.save(pelicula);
    }
}
