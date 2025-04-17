package com.cine.ejerciciopractico2_santiagobrenes.controller;


import com.cine.ejerciciopractico2_santiagobrenes.dao.PeliculaDao;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Pelicula;
import com.cine.ejerciciopractico2_santiagobrenes.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    PeliculaDao peliculaDao;
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("")
    public String getPeliculas(Model model) {
        List<Pelicula> peliculas = peliculaDao.findAll();
        System.out.println(peliculas);
        model.addAttribute("peliculas", peliculas);

        return "/admin/peliculas/peliculas";
    }

    @GetMapping("/nueva")
    public String nuevaPelicula(Pelicula pelicula) {
        return "/admin/peliculas/form_pelicula";
    }

    @PostMapping("/guardar")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.savePelicula(pelicula);
        return "redirect:/peliculas"; // o la ruta que usés para listar
    }
}
