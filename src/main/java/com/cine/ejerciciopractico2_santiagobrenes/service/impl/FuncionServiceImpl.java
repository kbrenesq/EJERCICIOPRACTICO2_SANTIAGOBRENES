package com.cine.ejerciciopractico2_santiagobrenes.service.impl;

import com.cine.ejerciciopractico2_santiagobrenes.dao.FuncionDao;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Funcion;
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
}
