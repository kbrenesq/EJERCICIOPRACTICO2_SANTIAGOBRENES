package com.cine.ejerciciopractico2_santiagobrenes.controller;

import com.cine.ejerciciopractico2_santiagobrenes.dao.PeliculaDao;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CarteleraController {
    @Autowired
    PeliculaDao peliculaDao;

    @GetMapping("/")
    public String getPeliculas(Model model) {
        List<Pelicula> peliculas = peliculaDao.findAll();
        System.out.println(peliculas);
        model.addAttribute("peliculas", peliculas);

        return "index";
    }
}
