package com.vitorrubenich.traveler.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorrubenich.traveler.model.Destino;


public interface DestinoRepository extends JpaRepository<Destino, Integer> {
    
}