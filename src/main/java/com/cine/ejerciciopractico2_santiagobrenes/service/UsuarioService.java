package com.cine.ejerciciopractico2_santiagobrenes.service;

import com.cine.ejerciciopractico2_santiagobrenes.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> getUsuarios();

    Usuario getUsuarioByCorreo(String correo);
}
