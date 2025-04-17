package com.cine.ejerciciopractico2_santiagobrenes.controller;


import com.cine.ejerciciopractico2_santiagobrenes.dao.UsuarioDao;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Pelicula;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioDao usuarioDao;

    @GetMapping("")
    public String getUsuarios(Model model) {
        List<Usuario> usuarios = usuarioDao.findAll();
        System.out.println(usuarios);
        model.addAttribute("usuarios", usuarios);

        return "/admin/usuarios/usuarios";
    }
}
