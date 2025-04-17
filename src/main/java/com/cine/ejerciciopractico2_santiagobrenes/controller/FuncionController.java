package com.cine.ejerciciopractico2_santiagobrenes.controller;


import com.cine.ejerciciopractico2_santiagobrenes.domain.Funcion;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Pelicula;
import com.cine.ejerciciopractico2_santiagobrenes.service.FuncionService;
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
@RequestMapping("/funcion")
public class FuncionController {
    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private FuncionService funcionService;


    @GetMapping("/nueva/{id_pelicula}")
    public String nuevaFuncion(Pelicula pelicula, Model model) {
        System.out.println(pelicula);
        pelicula = peliculaService.getPelicula(pelicula);
        Funcion funcion = new Funcion();
        funcion.setPelicula(pelicula);


        model.addAttribute("funcion", funcion);
        model.addAttribute("tituloPelicula", pelicula.getTitulo());


        return "/admin/peliculas/form_funcion";
    }

    @PostMapping("/guardar")
    public String guardarFuncion(@ModelAttribute Funcion funcion) {
        funcionService.save(funcion);
        return "redirect:/peliculas"; // o la ruta que usés para listar
    }
}
