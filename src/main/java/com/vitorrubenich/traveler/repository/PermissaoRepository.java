package com.vitorrubenich.traveler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitorrubenich.traveler.model.Permissao;


public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {
	//show result orber by id
    public List<Permissao> findAllByOrderByIdAsc();
}