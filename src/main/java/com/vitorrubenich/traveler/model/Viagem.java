package com.vitorrubenich.traveler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Viagem extends Entidade {

	@Column(nullable = false, length = 80)
	public String NomeDestino;

	@Column(nullable = false)
	public Double valor;
	
	
	public String getNomeDestino() {
		return NomeDestino;
	}

	public void setNomeDestino(String nomeDestino) {
		NomeDestino = nomeDestino;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
