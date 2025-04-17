package com.cine.ejerciciopractico2_santiagobrenes.controller;


import com.cine.ejerciciopractico2_santiagobrenes.dao.PeliculaDao;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Funcion;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Pelicula;
import com.cine.ejerciciopractico2_santiagobrenes.service.FuncionService;
import com.cine.ejerciciopractico2_santiagobrenes.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    PeliculaDao peliculaDao;
    @Autowired
    private PeliculaService peliculaService;
    @Autowired
    private FuncionService funcionService;

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

    @GetMapping("/pelicula/{id_pelicula}")
    public String getPelicula(Pelicula pelicula, Model model) {
         pelicula = peliculaService.getPelicula(pelicula);
         List<Funcion> funciones = funcionService.getFuncionesByPelicula(pelicula);
         model.addAttribute("pelicula", pelicula);
         model.addAttribute("funciones", funciones);

         return "/pelicula";
    }
}
