package com.cine.ejerciciopractico2_santiagobrenes.dao;

import com.cine.ejerciciopractico2_santiagobrenes.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
}
