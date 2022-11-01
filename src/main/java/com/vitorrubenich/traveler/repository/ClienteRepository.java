package com.vitorrubenich.traveler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorrubenich.traveler.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
