package com.vitorrubenich.traveler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorrubenich.traveler.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
