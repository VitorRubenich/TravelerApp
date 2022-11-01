package com.vitorrubenich.traveler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vitorrubenich.traveler.model.Promocao;

public interface PromocaoRepository extends JpaRepository<Promocao, Integer>{
    
}
