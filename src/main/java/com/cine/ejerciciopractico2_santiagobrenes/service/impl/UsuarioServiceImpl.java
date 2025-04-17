package com.cine.ejerciciopractico2_santiagobrenes.service.impl;

import com.cine.ejerciciopractico2_santiagobrenes.dao.UsuarioDao;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Usuario;
import com.cine.ejerciciopractico2_santiagobrenes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }
}
