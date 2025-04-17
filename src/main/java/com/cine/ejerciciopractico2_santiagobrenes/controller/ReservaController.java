package com.cine.ejerciciopractico2_santiagobrenes.controller;


import com.cine.ejerciciopractico2_santiagobrenes.domain.Funcion;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Pelicula;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Reserva;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Usuario;
import com.cine.ejerciciopractico2_santiagobrenes.service.FuncionService;
import com.cine.ejerciciopractico2_santiagobrenes.service.PeliculaService;
import com.cine.ejerciciopractico2_santiagobrenes.service.ReservaService;
import com.cine.ejerciciopractico2_santiagobrenes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FuncionService funcionService;


    @GetMapping("/nueva/{funcion_id}")
    public String nuevaReserva(Funcion funcion, Principal principal,  Model model) {
        System.out.println(funcion);
        Reserva reserva = new Reserva();
        funcion= funcionService.getFuncion(funcion);

        Usuario usuario = usuarioService.getUsuarioByCorreo(principal.getName());
        System.out.println(usuario);

        reserva.setFuncion(funcion);
        reserva.setUsuario(usuario);

        System.out.println(reserva);

        // Pasar la reserva, funcion y usuario al modelo
        model.addAttribute("reserva", reserva);
        model.addAttribute("funcion", funcion);
        model.addAttribute("usuario", usuario);

        return "reserva";
    }

    @PostMapping("/guardar")
    public String guardarReserva(Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/";
    }
}
