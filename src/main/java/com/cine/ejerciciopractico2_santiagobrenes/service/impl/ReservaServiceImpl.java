package com.cine.ejerciciopractico2_santiagobrenes.service.impl;

import com.cine.ejerciciopractico2_santiagobrenes.dao.ReservaDao;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Reserva;
import com.cine.ejerciciopractico2_santiagobrenes.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaDao reservaDao;


    @Override
    public List<Reserva> getReservas() {
        return reservaDao.findAll();
    }
}
