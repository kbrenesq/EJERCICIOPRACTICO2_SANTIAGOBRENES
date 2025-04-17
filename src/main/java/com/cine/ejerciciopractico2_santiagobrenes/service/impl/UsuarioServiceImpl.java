package com.cine.ejerciciopractico2_santiagobrenes.service.impl;

import com.cine.ejerciciopractico2_santiagobrenes.dao.UsuarioDao;
import com.cine.ejerciciopractico2_santiagobrenes.domain.Usuario;
import com.cine.ejerciciopractico2_santiagobrenes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario getUsuarioByCorreo(String correo) {
        return usuarioDao.findByCorreo(correo);
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        // Buscar el usuario por su nombre de usuario en la base de datos
        Usuario usuario = usuarioDao.findByCorreo(correo);

        // Si el usuario no existe, lanzar una excepción
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + correo);
        }

        // Devolver un objeto UserDetails con los datos del usuario
        return User.builder()
                .username(usuario.getCorreo())
                .password(usuario.getContrasena()) // Asegúrate de que la contraseña esté encriptada en la base de datos
                .roles(usuario.getRol()) // Asumiendo que los roles son un String como "USER", "ADMIN"
                .build();
    }
}
