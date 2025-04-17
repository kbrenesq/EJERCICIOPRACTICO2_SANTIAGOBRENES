package com.cine.ejerciciopractico2_santiagobrenes.service.impl;

import com.cine.ejerciciopractico2_santiagobrenes.dao.FuncionDao;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Funcion;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Pelicula;
import com.cine.ejerciciopractico2_santiagobrenes.service.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionServiceImpl implements FuncionService {

    @Autowired
    private FuncionDao funcionDao;


    @Override
    public List<Funcion> getFunciones() {
        return funcionDao.findAll();
    }

    @Override
    public void save(Funcion funcion) {
        funcionDao.save(funcion);
    }

    @Override
    public Funcion getFuncion(Funcion funcion) {
        return funcionDao.findById(funcion.getId()).orElse(null);
    }

    @Override
    public List<Funcion> getFuncionesByPelicula(Pelicula pelicula) {
        return funcionDao.findFuncionsByPelicula(pelicula);
    }
}
